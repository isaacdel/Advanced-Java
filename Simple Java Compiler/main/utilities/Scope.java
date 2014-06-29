package oop.ex7.main.utilities;

import java.util.ArrayList;
/**
 * this class describe a scope
 * @author Admin
 *
 */
public class Scope {
	ArrayList<Variables> varBlock;
	/**
	 * scope c-tor
	 */
	public Scope() {
		this.varBlock = new ArrayList<>();
	}
	/**
	 * check if exsisted in the scope
	 * @param name
	 * @return
	 */
	public Variables isExistInScope(String name){
		for(Variables var: varBlock){
			if(var.getName().compareTo(name) == 0){
				return var;
			}
		}
		return null;
	}
	/**
	 * insert variable to the scope.
	 * @param var
	 */
	public void insertVar(Variables var){
		varBlock.add(var);
	}
}
