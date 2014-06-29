/**
 * this class create method
 */
package oop.ex7.main.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import oop.ex7.main.Compiler;

public class Method {
	private int location;
	private String methodName;
	private ArrayList<String> parametrs;
	private String returnModifier;
	private LinkedList<Scope> scopeList;
	/**
	 * method c-tor
	 */
	public Method(){
		this.scopeList = new LinkedList<Scope>();
		scopeList.add(new Scope());

	}

	public Method(String methodName, ArrayList<String> parametersToInsert, 
			String returnModi){
		//create object of method witch have
		/*
		 * location: number of line in the text that the method start with.
		 * parameters: type list that the method should receive
		 * returnModi: type the method should return
		 * 
		 *  Variable[]: all the variables that the method holds.
		 */
		this.methodName = methodName;
		this.returnModifier = returnModi;

		this.scopeList = new LinkedList<Scope>();
		scopeList.add(new Scope());

		this.parametrs = parametersToInsert;

		this.location = Compiler.methLine;
	}
	/**
	 * return the method name
	 * @return
	 */
	public String getMethName(){return this.methodName;}
	/**
	 * return the type of the return
	 * @return
	 */
	public String getReturnModi(){return this.returnModifier;}
	/**
	 * return the location of the method declaration in the text 
	 * @return
	 */
	public int getLocation(){return this.location;}
	/**
	 * see a certain variable is the method
	 * @param name
	 * @return
	 */
	public Variables isInMethod(String name){
		Iterator<Scope> iter = scopeList.descendingIterator();
		Variables temp;
		while(iter.hasNext()){
			temp = (iter.next()).isExistInScope(name); 
			if(temp != null){return temp;}
		}
		return null;
	}
	/**
	 * insert a variable in the method
	 * @param var
	 */
	public void insertVar(Variables var){
		Iterator<Scope> iter = scopeList.descendingIterator();
		(iter.next()).insertVar(var);
	}
	/**
	 * delete a scope
	 */
	public void deleteScope() {
		scopeList.removeLast();
	}
	/**
	 * open new scope to store variables
	 */
	public void openNewScope() {
		Scope newScope = new Scope();
		scopeList.add(newScope);
	}
	/**
	 * return the method parameters types
	 * @return
	 */
	public ArrayList<String> getParametersType() {
		return this.parametrs;
	}
}
