package oop.ex7.main.checks;

import java.util.ArrayList;

import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.Store;
/**
 * this class takes care when there is if/while line.
 * @author Admin
 *
 */
public class IfWhileCheck {
	public static void ifWhileCheck(ArrayList<String> line) 
			throws ExceptionTypeOne{
		//checks if the variables are valids.
		for(int i=1; i< line.size();i++){
			VariableChecks.variableCheck(null, line.get(i));
		}
		//compare to see if the variable are the same type.
		for(int i=2; i< line.size();i++){
			VariableChecks.varComp(line.get(i-1), line.get(i));
		}
		//open scope to store new variables if need.
		Store.openScope();
	}
}
