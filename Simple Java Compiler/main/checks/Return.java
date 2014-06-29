package oop.ex7.main.checks;



import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.Store;
/**
 * this class checks in case of return.
 * @author Admin
 *
 */
public class Return {
public static final int NO_SPACE = -1; 	
	
	public static void returnCheck(String line) throws ExceptionTypeOne {
		line = line.trim();
		if(line.indexOf(" ")==NO_SPACE){
			compareTypeToMeth("void");
		}
		else{ String typeforCheck = RightSideCheck.rightSideCheck
				(line.substring(line.indexOf(" ")));
		compareTypeToMeth(typeforCheck);
		}
	}

	/*
	 * see that the return parameters is the same as the method return type.
	 */
	private static void compareTypeToMeth(String type) throws ExceptionTypeOne{
		String methType = Store.giveMeCurrentMethType();
		if(!methType.equals(type)){throw new ExceptionTypeOne("return err");}

	}


}
