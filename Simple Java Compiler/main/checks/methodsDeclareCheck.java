package oop.ex7.main.checks;

import java.util.ArrayList;
import java.util.regex.Pattern;
import oop.ex7.main.Compiler;

import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;
import oop.ex7.main.utilities.Store;
/**
 * this class is deal with method declaration.
 * @author Admin
 *
 */
public class methodsDeclareCheck {
	public static void declareCheck(ArrayList<String> stringArr)
			throws ExceptionTypeOne{
		//see if the method is already existed.
		if(!isMethodExisted(stringArr.get(1)) && Compiler.getTextRunNum()==1){
			//store the method in the data structure.
			Store.storeMethod(stringArr);
			for(int i=2; i<stringArr.size();i+=2){
				if(!methodParamChecks(stringArr.get(i),stringArr.get(i+1)))
				{throw new ExceptionTypeOne("methodDeclareCheck incorrect");}
				//check and store the variable in the declaration.
				VariableChecks.variableCheck(stringArr.get(i),
						stringArr.get(i+1));
			}
		}
		
	}
	/*
	 * check that the parameters is valid
	 */
	private static boolean methodParamChecks(String modify, String varName) {
		return (Pattern.compile(RagexUtils.VALID_MODIFY).matcher(modify)
				.matches())&&
				(Pattern.compile(RagexUtils.VALID_NAME_REG).matcher(varName)
						.matches());
	}
	/*
	 * see if the method existed.
	 */
	private static boolean isMethodExisted(String methodName) {
		
		return (Store.isMethodExisted(methodName));
	}
}
