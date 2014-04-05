/**
 * This class represents a math term between brackets
 *  (See latex's \right( and \left)).
 * @author OOP
 *
 */
public class BracketsMathTerm extends MathTerm {
	private MathTerm brTerm;
	/**
	 * The constructor receives the MathTerm they will be rendered as the 
	 * term inside the brackets.
	 * @param internalTerm-The term that resides within the brackets.
	 */
	public BracketsMathTerm(MathTerm internalTerm){
		brTerm=internalTerm;
	}
	/**
	 * Generates the latex representation of for this bracket math term.
	 */
	public java.lang.String toLatex(){
		//prints the braced expression while also checking for exp,bar or neg.
		return latexPrint("\\left( "+ this.brTerm.toLatex() +" \\right)");

	}
}
