package oop.ex7.main.checks;

import java.util.ArrayList;

import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;
import oop.ex7.main.utilities.Store;
/**
 * this class checks if the is a case of calling for method
 * foo(a,b); for example.
 * @author Admin
 *
 */
public class MethodCallCheck {
	public static void methodCallCheck(String line) throws ExceptionTypeOne{
		line = line.trim();
		String name = line.substring(0,line.indexOf("("));
		/*
		 * see if the method is already existed. 
		 */
		if(Store.isMethodExisted(name)){
			String values = line.substring(line.indexOf("("+1),
					line.indexOf(")"));
			//split and check variable in the method call.
			if(values!=null){
				String[] paramToCheck = values.split
						(RagexUtils.INNER_SPLIT_REG);
				ArrayList<String> methParam = Store.giveMeMethParamTypes(name);
				
				for(int i =0; i<paramToCheck.length;i++){
					String valueType = RightSideCheck.rightSideCheck
							(paramToCheck[i]);
					if(!methParam.get(i).equals(valueType))
					{throw new ExceptionTypeOne("methodCallCheck incorrect");}
				}
			}
			
		}
	}
}
