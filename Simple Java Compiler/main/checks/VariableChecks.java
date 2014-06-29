package oop.ex7.main.checks;

import java.util.regex.*;

import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;
import oop.ex7.main.utilities.Store;
/**
 * this class deals with all the checks that related to variables
 * @author Admin
 *
 */
public class VariableChecks {
	public static void variableCheck(String modi, String varName)
			throws ExceptionTypeOne{
		//case: x 
		if(modi == null){

			if(!varExisted(null, varName)){throw new ExceptionTypeOne
				("variable is not exsist");}
		}
		//case: int x;
		else{
			boolean isArray = isArray(modi);
			if(goodName(varName) && goodModi(modi)){
				if(!varExisted(modi, varName)){
					Store.storeVariable(modi, varName,isArray);
				}
			}
		}
	}

	private static boolean isArray(String modi) throws ExceptionTypeOne {
		if(Pattern.compile(RagexUtils.IS_ARR_DECLARE_REG).matcher(modi)
				.matches()){
			if(modi.indexOf("[") - modi.indexOf("]") > 1){
				/*need to check the inside block*/
				String insideCheck = modi.substring(modi.indexOf("["+1),
						modi.indexOf("]"));
				inBlockCheck(insideCheck);
			}
			return true;
		}
		return false;
	}
	/*
	 * check in case of x[], than the method will check inside the []
	 */
	private static void inBlockCheck(String insideCheck) 
			throws ExceptionTypeOne {
		Matcher m = Pattern.compile(RagexUtils.IN_ARR_CHECK_REG)
				.matcher(insideCheck);
		if(m.find()){
			if((m.group(2).matches(RagexUtils.DOUBLE_MATCH_REG+"|"+
					RagexUtils.INT_MATCH_REG))){
				if(m.group(6) != null){
					if(!(m.group(6).matches(RagexUtils.DOUBLE_MATCH_REG+"|"
							+RagexUtils.INT_MATCH_REG))){
						throw new ExceptionTypeOne
						("inBlockCheck: wrong second input");}
				}
			}
			else{throw new ExceptionTypeOne
				("inBlockCheck: wrong first input");}

		}

	}
	/*
	 * see if the variable is already existed
	 */
	private static boolean varExisted(String modi, String varName) {

		return Store.isVarExisted(varName);
	}
	/*
	 * see if the modifier is valid
	 */
	private static boolean goodModi(String modi) {
		//regex.
		Matcher m;
		return ((m = Pattern.compile(RagexUtils.VALID_MODIFY).matcher(modi))
				.matches());
	}
	/*
	 * see if the variable name is valid
	 */
	private static boolean goodName(String varName) {
		//regex
		Matcher m;
		return ((m = Pattern.compile(RagexUtils.VALID_NAME_REG)
				.matcher(varName)).matches());
	}
	/*
	 * compare between two variables and return if there type is the same or not
	 */
	public static boolean varComp(String var1, String var2){
		String typeVar1 = Store.giveMeVariableType(var1);
		String typeVar2 = Store.giveMeVariableType(var2);
		return (typeVar1.compareTo(typeVar2) == 0);
	}
	/*
	 * see if the array is array type
	 */
	public static boolean isArrType(String string) {

		return Store.giveMeVariableIsArray(string);
	}

}
