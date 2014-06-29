/**
 * this class create variables
 */
package oop.ex7.main.utilities;
/**
 * this class describe a variable
 * @author Admin
 *
 */
public class Variables {
	private String name;
	private String type;
	private boolean isArray;
	private boolean isInit;
	/**
	 * c-tor
	 * @param type
	 * @param name
	 * @param isArray
	 */
	public Variables(String type, String name, boolean isArray){
		this.name = name;
		this.type = type;
		this.isArray = isArray;
		this.isInit = true;
	}
	/**
	 * return the variable name
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * return the type of the variable
	 * @return
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * return if the variable is array
	 * @return
	 */
	public boolean isArray(){
		return this.isArray;
	}
	/**
	 * return if the array is already initialize.
	 * @return
	 */
	public boolean isInit(){
		return this.isInit;
	}
}
