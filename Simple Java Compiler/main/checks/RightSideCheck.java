package oop.ex7.main.checks;

import java.util.ArrayList;
import java.util.regex.*;

import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;
import oop.ex7.main.utilities.Store;
/**
 * this class deal with the right side in case of assignment operator.
 * @author Admin
 *
 */
public class RightSideCheck {
public static final int LEFT_SIDE_OPERATOR = 1;
public static final int RIGHT_SIDE_OPERATOR = 3;

	public static String rightSideCheck(String line) throws ExceptionTypeOne{
		String lookLike = howLineLook(line);
		switch (lookLike) {
		case "char":
			return "char";
		case "array content":
			return arrayTypeCheck(line);
		case "operator":
			return operatorCheck(line);
		case "int":
			return "int";
		case "double":
			return "double";
		case "String":
			return "String";
		case "boolean":
			return "boolean";
		case "method call":
			return methodType(line);
		case "variable":
			return variableType(line);
		default:
			return "wrong input";
		}
	}


	/*
	 * case: x
	 */
	private static String variableType(String line) throws ExceptionTypeOne {
		line= line.trim();
		String varTocheck = line.substring(0, line.indexOf(";"));
		VariableChecks.variableCheck(null, varTocheck);
		String varType = Store.giveMeVariableType(varTocheck);
		return varType;
	}


	/*
	 * case: call for method foo();
	 */
	private static String methodType(String line) throws ExceptionTypeOne {
		line = line.trim();
		MethodCallCheck.methodCallCheck(line);
		String[] methName = line.split("\\(");
		String methType = Store.getMethodTypeByName(methName[0]); 
		return methType;
	}


	/*
	 * case: [1+6] [a+b] [1+b]
	 */
	private static String operatorCheck(String line) throws ExceptionTypeOne {
		if((Pattern.compile(RagexUtils.ISNOT_VALID_OPERATOR).matcher(line)
				.matches()))
		{throw new ExceptionTypeOne("operator check: invalid operator");}
		line=line.trim();
		Matcher m = Pattern.compile(RagexUtils.GROUP_OPERATOR).matcher(line);
		String res="";
		String res2="";
		if (m.find()){
			res = m.group(LEFT_SIDE_OPERATOR);
			res2 = m.group(RIGHT_SIDE_OPERATOR);
		}
		//see how both sides looks
		String leftSideToCheck = howLineLook(res);
		String rightSideToCheck = howLineLook(res2);
		//in case of methods call.
		if(leftSideToCheck.equals("method call")){
			leftSideToCheck = leftSideToCheck.trim();
			MethodCallCheck.methodCallCheck(leftSideToCheck);
			leftSideToCheck = Store.getMethodTypeByName
					(leftSideToCheck.substring(leftSideToCheck.indexOf(0,
							leftSideToCheck.indexOf("("))));
		}
		if(rightSideToCheck.equals("method call")){
			rightSideToCheck = rightSideToCheck.trim();
			MethodCallCheck.methodCallCheck(rightSideToCheck);
			rightSideToCheck = Store.getMethodTypeByName
					(rightSideToCheck.substring(rightSideToCheck.indexOf(0),
							rightSideToCheck.indexOf("(")));
		}
		//see that both side of the operator are the same
		if( ! leftSideToCheck.equals(rightSideToCheck))
		{throw new ExceptionTypeOne("operator check: left inequal to right");}

		return leftSideToCheck;
	}


	/*
	 * case: {1,2,3,4}
	 */
	private static String arrayTypeCheck(String line) throws ExceptionTypeOne {
		if((Pattern.compile("\\s*\\{\\s*\\,\\s*\\w+\\s*}\\s*;?").matcher(line)).matches()){throw new ExceptionTypeOne("err");}
		//case: {}
		String inner;
		if(line.indexOf("}")-line.indexOf("{")<=1){return "empty";}
		else{inner = line.substring(line.indexOf("{")+1, line.indexOf("}"));}
		//split inside the { }
		inner = inner.trim();
		String[] splited = inner.split(",");
		operatorCheck(splited);
		String[] allLineSplited = completedSplit(inner);
		String typeToCompare = howLineLook(allLineSplited[0]);
		if(typeToCompare.equals("variable")){
			typeToCompare = Store.giveMeVariableType(allLineSplited[0]);
		}
		String typeCheck ="";
		for(String word: allLineSplited){
			typeCheck = howLineLook(word);
			if(typeCheck.equals("variable")){
				typeCheck = Store.giveMeVariableType(word);
			}
			if(!(typeToCompare.equals(typeCheck))){throw new ExceptionTypeOne
				("arrayTypeCheck:");}
		}
		
		return typeCheck;
	}



	//split the inner array.
	private static String[] completedSplit(String line) throws ExceptionTypeOne {
		String innerCheck = line;
		while(innerCheck.indexOf(",")!=-1){
			innerCheck = innerCheck.substring(innerCheck.indexOf(","));
			if(((Pattern.compile("(-?\\s*\\w*\\s*,)+").matcher(innerCheck)).matches())){throw new ExceptionTypeOne("");}
			innerCheck = innerCheck.substring(innerCheck.indexOf(",")+1);
		}

		String[] rr = line.split(",|\\+|\\*|\\-|\\/");
		ArrayList<String> re = new ArrayList<>();
		for(String word: rr){
		word=word.trim();
			if(!word.equals("")){
				re.add(word);
			}
		}
		String[] result = new String[re.size()];
		int i=0;
		for(String word: re){
			result[i] = word;
			i++;
		}
		return result;
	}


	/*
	 * check in case of operator that the values are valid
	 */
	private static void operatorCheck(String[] splited) 
			throws ExceptionTypeOne {
		for(String word:splited){
			if(howLineLook(word).equals("operator")){
				if((Pattern.compile(RagexUtils.ISNOT_VALID_OPERATOR).matcher
						(word).matches())){throw new ExceptionTypeOne
					("operatoeCheck invalid operator2");}
			}
		}
	}


	/*
	 * see how this line look.
	 */
	private static String howLineLook(String line) {
		//'c'
		if((Pattern.compile(RagexUtils.CHAR_MATCH_REG).matcher(line))
				.matches()){
			return "char";
		}
		//{1,2,3}
		else if((Pattern.compile(RagexUtils.ARRAY_CONTENT_MATCH).matcher(line))
				.matches()){
			return "array content";
		}
		//1+2
		else if((Pattern.compile(RagexUtils.OPERATOR_CONTENT_MATCH)
				.matcher(line)).matches()){
			return "operator";
		}
		//1
		else if((Pattern.compile(RagexUtils.INT_MATCH_REG).matcher(line))
				.matches()){return "int";}
		//2.1
		else if((Pattern.compile(RagexUtils.DOUBLE_MATCH_REG).matcher(line))
				.matches()){return "double";}
		//"string"
		else if((Pattern.compile(RagexUtils.STRING_MATCH_REG).matcher(line))
				.matches()){return "String";}
		//true|false
		else if((Pattern.compile(RagexUtils.BOOLEAN_MATCH_REG).matcher(line))
				.matches()){return "boolean";}
		//foo();
		else if((Pattern.compile(RagexUtils.METHOD_CALL_MATCH_REG)
				.matcher(line)).matches()){return "method call";}
		//x
		else if((Pattern.compile(RagexUtils.VALID_NAME_REG+"\\s*;?")
				.matcher(line)).matches()){return "variable";}
		//if is not one of them than the input is incorrect
		return "wrong input";
	}
}

