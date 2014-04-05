/**
 * This class represents a simple operation between two other terms. 
 * For example, "a+b", "c*d" or "c=d","x
 * @author isaacdelarosa
 *
 */
public class SimpleBinaryOpMathTerm extends BinaryMathTerm {
	private char sign;
	/**
	 * Instantiate a new SimpleBinaryOpMathTerm. Keep in mind that since this
	 *  class extends BinaryMathTerm, and 
	 * BinaryMathTerm can not be 
	 * instantiated without parameters (no default constructor), 
	 * this constructor should call its superclass constructor explicitly 
	 * (As seen in class, using super() keyword).
	 * @param firstTerm-The first term of the binary operation.
	 * @param secondTerm-The second term of the binary operation.
	 * @param sign- The operation sign. 
	 * Can be any of the following: "+,-,*,<,>,=". If sign == '*', 
	 * you should use the 
	 * \cdot latex command (a\cdotb). 
	 * Otherwise you can use sign itself.
	 */
	public SimpleBinaryOpMathTerm
	(MathTerm firstTerm, MathTerm secondTerm,char sign) {
		super(firstTerm, secondTerm);
		this.sign=sign;
	}
	/**
	 * Generates the latex representation of this arithmetic operation 
	 * math term. (See comment in constructor regarding
	 *  the multiplication sign)
	 * @return The latex representation of the operation:
	 *  "firstTerm operationSign secondTerm".
	 */
	public java.lang.String toLatex(){
		//prints the multiplied or other math operation while also 
		//checking for exp,bar or neg.
		if (this.sign=='*'){
			return ""+this._firstTerm.toLatex()+" \\cdot "
					+this._secondTerm.toLatex()+"";
		}
		else
			return ""+this._firstTerm.toLatex()+""+sign+""
			+this._secondTerm.toLatex()+"";
	}
}
