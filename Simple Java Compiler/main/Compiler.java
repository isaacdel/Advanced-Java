/**
 * this class receive array of text perform basic checks
 * and identify each line.
 */
package oop.ex7.main;
import oop.ex7.main.checks.*;
import java.util.ArrayList;

import java.util.LinkedList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import oop.ex7.main.checks.AssignmentCheck;
import oop.ex7.main.checks.IfWhileCheck;
import oop.ex7.main.checks.VariableChecks;
import oop.ex7.main.checks.methodsDeclareCheck;
import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;
import oop.ex7.main.utilities.Store;


public class Compiler {
	private int finalResult = 0;
	public static int methLine = 0;
	private LinkedList<Integer> methIndex = new LinkedList<>();
	private	int scopeCounter = 0;
	private int insideMethodScopeCounter = 1;
	public static int currentMeth=0;
	public static int textRunCounter = 1;
	public static int compilerTextRunNum = 0;
	public static int methLocationForOwnVar = 0;
	/**
	 * this method receive the text and will identify and check each line
	 * @param text
	 * @return
	 * @throws ExceptionTypeOne 
	 */
	public Compiler (String[] text) throws ExceptionTypeOne  {
		try{	
			/*
			 * initializing method to insert all the globals variables
			 */
			Store.initGlobalsMethod();
			
			/*first run on the text
			 *passes only on the list of the methods 
			 */
			for(String line: text){
				methLine ++;
				compilerTextRunNum =1;
				if((Pattern.compile(RagexUtils.METHOD_DECLARE_MATCH_REG))
						.matcher(line).matches()){
					methIndex.add(methLine);
					methLocationForOwnVar++;
					identifyLine(line);
				}
			}
			/*second run on the text
			 * checking and storing all the globals
			 * (every things that is valid and locate out side the methods )
			 * examples: [int x;] [int y = 3] [int[] r ={1,2,3,4}] [foo();]
			 */
			int i=0;
			while( i<text.length){
				compilerTextRunNum =2;
				if((Pattern.compile(RagexUtils.METHOD_DECLARE_MATCH_REG))
						.matcher(text[i]).matches()){
					scopeCounter++;
					while(scopeCounter != 0){
						if((Pattern.compile(RagexUtils.IF_WHILE_REG))
								.matcher(text[i]).matches()){scopeCounter++;}
						if((Pattern.compile(RagexUtils.END_SCOPE_REG))
								.matcher(text[i]).matches()){scopeCounter--;}
						if(i>text.length){throw new ExceptionTypeOne
							("mising end scope");}
						i++;
					}
				}
				else{identifyLine(text[i]);i++;};
				
			}
			/*third run only inside the methods
			 * and check inside each methods.
			 */

			while(methIndex.iterator().hasNext()){
				compilerTextRunNum =3;
				int freshLine = methIndex.poll();
				currentMeth = freshLine;
				
				while(insideMethodScopeCounter != 0 && freshLine!=text.length){
					if(identifyLine(text[freshLine])){
						throw new ExceptionTypeOne("inside method decleration");
						}
					freshLine++;

				}
			}
		}catch(ExceptionTypeOne e){
			this.finalResult = 1;

		}
	}

	/*
	 * this method identify each line.
	 */
	private boolean identifyLine(String line) throws ExceptionTypeOne{
		ArrayList<ArrayList<String>> temp = new ArrayList<>();
		temp = Parser.parser(line);
		Matcher m;
		// case: method declaration
		if ((m = Pattern.compile(RagexUtils.METHOD_DECLARE_MATCH_REG)
				.matcher(line)).matches()) {
			methodsDeclareCheck.declareCheck(temp.get(0));
			insideMethodScopeCounter++;
			return true;
		}


		// case: variable declaration:	{int a;}	
		else if((m=Pattern.compile(RagexUtils.SINGLE_VARIABLE_DECLARATION_REG)
				.matcher(line)).matches()){
			Matcher match = Pattern.compile(RagexUtils.VALID_SINGLE_VARIABLE)
					.matcher(line);
			if(match.find()){
				String modifier = match.group(1);
				String var = match.group(2);
				var= var.trim();
				modifier = (Pattern.compile("\\s+").matcher(modifier))
						.replaceAll("");

			VariableChecks.variableCheck(modifier,var);
			}
			return false;
		}
		//case: is assignment : {int a = b}
		else if ((m = Pattern.compile(RagexUtils.IS_ASSIGNMENT_OPERATOR)
				.matcher(line)).matches()){
			AssignmentCheck.assignmentCheck(line);
			return false;
		}
		//case: is if/while : {if(a>b)} {while(a>b)}
		else if((m = Pattern.compile(RagexUtils.IF_WHILE_REG).matcher(line))
				.matches()){
			IfWhileCheck.ifWhileCheck(temp.get(0));
			insideMethodScopeCounter++;
			scopeCounter++;
			return false;
		}
		//case: end of scope {"}"}
		else if((m = Pattern.compile(RagexUtils.END_SCOPE_REG).matcher(line))
				.matches()){
			if(scopeCounter < 0){throw new ExceptionTypeOne
				("too many scopes");}

			insideMethodScopeCounter--;
			scopeCounter--;
			EndScope.endScope();
		}
		//case : return: {return a+d;}
		else if((m = Pattern.compile(RagexUtils.RETURN_LINE_REG).matcher(line))
				.matches()){
			Return.returnCheck(line);
			return false;
		}
		//case: method call {foo(a,b);}
		else if((m = Pattern.compile(RagexUtils.METH_CALL_REG).matcher(line))
				.matches()){
			MethodCallCheck.methodCallCheck(line);
			return false;
		}
		else{throw new ExceptionTypeOne("incorrect line");}
		return false;
	}
	/**
	 * return the method location for insertions purposes.
	 * @return
	 */
	public static int getMethLocationForOwnVar(){
		return methLocationForOwnVar;
	}
	/**
	 * return witch line the compiler read.
	 * @return
	 */
	public static int getCompTextRunNum(){
		return compilerTextRunNum;
	}
	/**
	 * return witch method is currently we deal.
	 * @return
	 */
	public static int getCurrentMeth(){
		return currentMeth;
	}
	/**
	 * return how cuurent time the compiler run on the text.
	 * @return
	 */
	public static int getTextRunNum(){
		return textRunCounter;
	}
	/**
	 * return the result of the compiler
	 * @return if ok - 0, if not - 1.
	 */
	public int getResult() {
		return this.finalResult;
	}
}
