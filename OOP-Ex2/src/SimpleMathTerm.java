import java.text.DecimalFormat;
/**
 * This class represents a math term which is either a single letter 
 * variable (x,y,a,b,etc..) or a number 
 * (may be a floating point number).
 *  The latex representation is straight forward the name of the 
 *  variable, or the number itself.
 *   However, in case this term represents a number, the class will 
 *   allow to user to control the 
 *   precision of its latex representation,
 *   that is - the number of digits to the right of the floating dot.
 *    Note: The interface allows to 
 *   "annotate" the term with bar (upper line),
 *    negation or with other MathTerm as exponent. When more than one 
 *    of these annotations are set,
 *     please evaluate the latex 
 * representation in the following order: exponent, bar and then negation.
 * @author isaacdelarosa
 *
 */

public class SimpleMathTerm extends MathTerm {

	private String name;
	private String result;
	private int _precisionDigit;
	/**
	 * Constructs a new instance given a simple term "name" 
	 * (which can be a variable or a number).
	 * @param termName-A string of either a single letter variable 
	 * (x,y,z,a,b..) or a number
	 *  (may be a floating point number).
	 */
	public SimpleMathTerm(java.lang.String termName){
		this.name=termName;
	}
	/**
	 * Checks the given name. And determines whether it's numeric.
	 * @return true if this term represents a number.
	 */
	private boolean isNumeric(){
		if (Character.isLetter(name.charAt(0))) {
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * Sets the number of digits of precision in case this term represents 
	 * a number.
	 * @param precisionDigits-Number of digits right of the floating point 
	 * on the latex representation.
	 */
	public void setPrecisionDigits(int precisionDigits){
		_precisionDigit=precisionDigits;
		if(name.contains("."))
			this.name=truncateDouble(name, precisionDigits);
	}
	/**
	 * this method actually trims the number.
	 * @param number the number that will change.
	 * @param numDigits the number of digits of the presition.
	 * @return the fixed number
	 */
	private String truncateDouble(String number, int numDigits) {
		result = number;
		String arg = "" + number;
		int idx = arg.indexOf('.');
		//truncate the number in a specific way when presitiondigit is zero.
		if(numDigits==0){
			String nu=arg.substring(0,idx);
			System.out.println(nu);
			return	nu;
		}
		else if (idx!=-1 && numDigits!=0) {
			//checks that the number is "truncatble".
			if (arg.length() > idx+numDigits) {
				//takes only part (the wanted) length from the original 
				//string number.
				arg = arg.substring(0,idx+numDigits+1);
				result  = arg;
			}
		}
		return result;
	}
	/**
	 * Generates the latex representation of the this simple math term.
	 * the Latex representation. If this term represents a variable, this
	 *  method returns the variable name.
	 *  Otherwise, if the term represents
	 *  a number it should be trimmed to according to the precision parameter.
	 *  @return the Latex representation. If this term represents a variable
	 *  , this method returns the variable name. 
	 *  Otherwise, if the term represents a number it should be trimmed to
	 *   according to the precision parameter.
	 */
	public java.lang.String toLatex(){
		{
			return latexPrint(name);
		}
	}
}




