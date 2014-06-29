package oop.ex7.main.checks;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


import oop.ex7.main.utilities.ExceptionTypeOne;
import oop.ex7.main.utilities.RagexUtils;
import oop.ex7.main.utilities.Store;
/**
 * this class check if the line is look like [something] = [something];
 * @author Admin
 *
 */
public class AssignmentCheck {
	public static void assignmentCheck(String line) throws ExceptionTypeOne{
	/*
	 * Separated the line into right and left side.
	 */
		line = line.trim();
		String leftLine = line.substring(0,line.indexOf("="));
		String rightLine = line.substring(line.indexOf("=")+1);
		/*
		 * check the right side and left side separately
		 */
		String rightSideType = RightSideCheck.rightSideCheck(rightLine);
		String leftSideLook = leftLookLike(leftLine);
		/*
		 * check if array is involve.
		 */
		isArrayAssignmentBasicCheck(leftLine, rightLine);
		
		/*
		 * compare between both sides
		 */
		if(leftSideLook.compareTo(rightSideType)!=0){
			if(rightSideType != "empty"){
				if(leftSideLook.indexOf("[")!=-1){
					leftSideLook = leftSideLook.trim();
					leftSideLook=leftSideLook.substring(0, 
							leftSideLook.indexOf("["));

					boolean isIntToDouble = doubleIntCheck(leftSideLook,rightSideType);
					if(leftSideLook.compareTo(rightSideType)!=0 && ! isIntToDouble){throw new ExceptionTypeOne("err");}
				}
				boolean isIntToDouble = doubleIntCheck(leftSideLook,rightSideType);
				if(leftSideLook.compareTo(rightSideType)!=0 &&  ! isIntToDouble){
					throw new ExceptionTypeOne("");
				}
			}
		}

	}
	private static boolean doubleIntCheck(String leftSideLook, String rightSideType) throws ExceptionTypeOne {
		if(leftSideLook.equals("double")&&!(rightSideType.equals("int")||rightSideType.equals("double"))){
			throw new ExceptionTypeOne("err");
		}
		if(leftSideLook.equals("double")&&rightSideType.equals("int")){return true;}
		return false;
	}
	/*
	 *identify the left side. 
	 */
	private static String leftLookLike(String leftLine) 
			throws ExceptionTypeOne {
		leftLine= leftLine.trim();
		//case: int x
		if((Pattern.compile(RagexUtils.VALID_MODIFY+RagexUtils.WHITE_SPACE_REG
				+RagexUtils.VALID_NAME_REG).matcher(leftLine)).matches()){
			Matcher m = Pattern.compile(RagexUtils.GROUP_VARIABLE_DECLERATION)
					.matcher(leftLine);
			if(m.find()){
				String modifier = m.group(1);
				String var = m.group(2);
				var= var.trim();
				modifier = (Pattern.compile("\\s+").matcher(modifier))
						.replaceAll("");
				VariableChecks.variableCheck(modifier, var);
			}
			return Store.giveMeVariableType(m.group(2));
		}
		//case: [x]
		if((Pattern.compile(RagexUtils.GROUP_SINGLE_VAR).matcher(leftLine))
				.matches()){
			Matcher m = Pattern.compile("("+RagexUtils.VALID_NAME_REG+")")
					.matcher(leftLine);
			if(m.find()){
				VariableChecks.variableCheck(null, m.group(1));
				checkArrVar(leftLine);
			}
			return Store.giveMeVariableType(m.group(1));

		}
		else{throw new ExceptionTypeOne(" assigment check left look like");}
	}
	//case: int[1] x
	private static void checkArrVar(String leftLine) throws ExceptionTypeOne {
		if(leftLine.indexOf("[")!=-1 && leftLine.indexOf("]")!=-1){
			leftLine= leftLine.trim();
			String VarToCheck = leftLine.substring(0,leftLine.indexOf("["));
			if( ! Store.giveMeVariableIsArray(VarToCheck))
			{throw new ExceptionTypeOne("");}

		}

	}
	/*
	 * case array instance: [ int[] x = {1,2,3,4} ]
	 */
	private static void isArrayAssignmentBasicCheck
	(String leftSide, String rightSide) throws ExceptionTypeOne {
		if((Pattern.compile(RagexUtils.VALID_MODIFY+RagexUtils.WHITE_SPACE_REG
				+RagexUtils.VALID_NAME_REG+"\\s*").matcher(leftSide))
				.matches()){
			if(leftSide.contains("[") && leftSide.contains("]")){
				if(!(rightSide.contains("{") && rightSide.contains("}"))){
					throw new ExceptionTypeOne
					("fail isArrayAssigmentBasicCheck: case: int[] x = {1,2,3}");
				}
			}
			else if((Pattern.compile(RagexUtils.RIGHT_SIDE_IS_ARRAY)
					.matcher(rightSide))
					.matches()){throw new ExceptionTypeOne("");}	
		}
		/*
		 * case: x = {1,2,3,4}
		 */
		else{
			leftSide = leftSide.trim();
			if(!leftSide.contains("[")){
				if(VariableChecks.isArrType(leftSide)){
					if(!(rightSide.contains("{") && rightSide.contains("};"))){
						throw new ExceptionTypeOne("fail case:x={1,2,3}");
					}	
				}
			}
		}
	}


}
