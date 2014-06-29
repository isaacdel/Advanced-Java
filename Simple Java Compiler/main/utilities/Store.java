package oop.ex7.main.utilities;

import java.util.ArrayList;

import oop.ex7.main.Compiler;

/**
 * this class managing the storing all the variables 
 * @author Admin
 *
 */
public class Store {
	/*
	 * array list that hole the methods
	 */
	
	public static ArrayList<Method> methodList = new ArrayList<>();
	/*
	 * store a variable in the method list
	 */
	public static void storeVariable(String modi, String varName,
			boolean isArray) {
		Variables newVar = new Variables(modi, varName, isArray);
		storeNewVar(newVar);

	}
	/*
	 * initialized a methods for global variables
	 */
	public static void initGlobalsMethod(){
		Method globalMeth = new Method();
		methodList.add(0,globalMeth);

	}
	/*
	 * locate and store new variables
	 */
	private static void storeNewVar(Variables newVar) {
		if(Compiler.getCompTextRunNum() ==1){
			methodList.get(Compiler.getMethLocationForOwnVar())
			.insertVar(newVar);
		}
		else{
			if(Compiler.getCompTextRunNum() == 2){
				methodList.get(0).insertVar(newVar);
			}
			else {
				int methIdx = getMethodIdx(Compiler.getCurrentMeth());

				methodList.get(methIdx).insertVar(newVar);
			}
		}
	}
	/*
	 * see a variable is already existed
	 */
	public static boolean isVarExisted(String varName) {

		return giveMeVar(varName)!= null;
	}
	public static Variables giveMeVar(String name){
		int currentLocation = Compiler.getCurrentMeth();
		int currentMethIdx= getMethodIdx(currentLocation); 
		Variables temp = methodList.get(0).isInMethod(name);
		if (temp == null){
			temp = methodList.get(currentMethIdx).isInMethod(name);
		}
		if(temp != null){
			return temp;
		}

		return null;
	}
	/*
	 * return the index of method in the array list
	 */
	private static int getMethodIdx(int currentLocation) {
		for(int i=0; i<methodList.size();i++){
			if(methodList.get(i).getLocation() == currentLocation){return i;}
		}
		return 0;
	}
	/**
	 * return the variable type
	 */
	public static String giveMeVariableType(String var1) {

		return giveMeVar(var1).getType();
	}
	/**
	 * return if a variable is array or not
	 * @param varName
	 * @return
	 */
	public static boolean giveMeVariableIsArray(String varName) {
		return giveMeVar(varName).isArray();
	}
	/**
	 * storing a method in the arraylist
	 * @param stringArr
	 */
	public static void storeMethod(ArrayList<String> stringArr) {
		String returnModifier = stringArr.get(0);
		String methodName = stringArr.get(1);
		ArrayList<String> parameters = new ArrayList<>();
		/*
		 * taking the parameters types only and arrange it in array
		 */
		for(int i = 2; i<stringArr.size();i+=2){
			parameters.add(stringArr.get(i));
		}
		Method newMethod = new Method(methodName,parameters, returnModifier);
		methodList.add(newMethod);
	}
	/**
	 * see if a method is exsisted or not
	 * @param name
	 * @return
	 */
	public static boolean isMethodExisted(String name) {
		for(Method methName: methodList){
			if(methName.getMethName() !=null && methName.getMethName()
					.equals(name)){return true;}
		}
		return false;
	}
	/**
	 * remove scope in the array list
	 */
	public static void removeScope() {

		(methodList.get(Store.getMethodIdx(Compiler.getCurrentMeth())))
		.deleteScope();
	}
	/**
	 * open scope in the arraylist
	 */
	public static void openScope() {
		methodList.get(Compiler.getCurrentMeth()).openNewScope();
	}
	/**
	 * return the method type that we deal with
	 * @return
	 */
	public static String giveMeCurrentMethType() {
		int methLocation = Compiler.getCurrentMeth();

		return methodList.get(getMethodIdx(methLocation)).getReturnModi();
	}
	/**
	 * return a method that located by his name
	 */
	public static String getMethodTypeByName(String methName) {
		for(Method meth: methodList){
			if(meth.getMethName().compareTo(methName)==0)
			{return meth.getReturnModi();}
		}
		return "not existed";
	}
	/**
	 * return the method parameters
	 * @param name
	 * @return
	 */
	public static ArrayList<String> giveMeMethParamTypes(String name) {
		for(Method method: methodList){
			if(method.getMethName().equals(name))
			{return method.getParametersType();}
		}
		return null;
	}


}
