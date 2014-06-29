package oop.ex7.main.checks;

import oop.ex7.main.utilities.Store;
/**
 * this class takes care when the scope ends.
 * @author Admin
 *
 */
public class EndScope {
	public static void endScope(){
		Store.removeScope();
	}
}
