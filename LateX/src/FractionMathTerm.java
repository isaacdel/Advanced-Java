/**
 * This class represents a special case of binary math term. It should be
 *  rendered as a fraction ("kav shever" in hebrew). 
 * Implement the toLatex method using Latex \frac command.
 * @author OOP
 *
 */
public class FractionMathTerm extends BinaryMathTerm {
	/**
	 * Constructs a new Fraction term. Keep in mind that the base class, 
	 * BinaryMathTerm, should be be instantiated explicitly
	 *  (see: SimpleBinaryOpMathTerm.SimpleBinaryOpMathTerm
	 *  (MathTerm, MathTerm, char)).

	 * @param firstTerm-Term on the numerator ("Mone").
	 * @param secondTerm-Term on the denominator ("Mechane").
	 */
	public FractionMathTerm(MathTerm firstTerm,MathTerm secondTerm){
		super(firstTerm,secondTerm);
	}
	/**
	 * Generates the latex representation of this fraction math term.
	 */
	public java.lang.String toLatex(){
		//prints the fraction expression while also checking for
		//exp,bar or neg.
		return latexPrint("\\frac{ " +this._firstTerm.toLatex()+" }" +
				"{ "+this._secondTerm.toLatex()+" }");
	}
}
