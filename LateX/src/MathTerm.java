/**
 * This class represents the base class for all other MathTerms classes you 
 * will implement in the exercise. 
 * It defines the interface (the public part of the classes) for all other
 *  math terms which will extend it. 
 * Most importantly, it defines the method "toLatex" that should be 
 * overridden in each of the extending classes.
 *  This class is not meant to be instantiated at any point, the only
 *   classes that will be instantiated are classes that extend it.
 *   Thus, the "toLatex" method should be left unimplemented (return ""). 
 *   It will be implemented, however, in any of this class' subclasses.
 *    The rest of the interface (setExponentTerm, setters and getters, etc.) 
 *    or any additions you may want to add to this class (as long as they 
 *    are hidden do not modify its interface),
 *  can and should be implemented in this class. Later on this course, 
 *  we will find a more elegant way to "enforce" subclasses to implement a 
 *  method rather than leaving unimplemented methods
 *   (abstract, interface).
 * @author OOP
 *
 */
public class MathTerm {
	private MathTerm exp;
	private boolean isBarred;
	private boolean isNegated;
	private boolean isExp;
	/**
	 * Default constructor.
	 */
	public MathTerm(){	
	}
	/**
	 * This method gets a math term to be placed as an exponent for the
	 *  current math term. For example.\
	 *  If our current MathTerm is "a" and the user passes "b". Then our
	 *   Mathterm will be rendered as "a^{ b }".
	 * @param exponentTerm- The MathTerm to be placed as an exponent of
	 *  the current term.
	 */
	public void setExponentTerm(MathTerm exponentTerm){
		isExp=true;
		this.exp=exponentTerm;
	}
	/**
	 * Returns the exponent math term.
	 * @return -The exponent MathTerm of this term.
	 */
	public MathTerm getExponentTerm(){
		return exp;
	}
	/**
	 * Setting whether this MathTerm should be barred or not 
	 * (a straight line on top of the term: see Latex's \overline{}).
	 * @param isBarred-true if we want this term to be barred.
	 */
	public void setIsBarred(boolean isBarred){
		this.isBarred=isBarred;
	}
	/**
	 * isBarred getter.
	 * @return-returns whether this math term was set to be barred.
	 */
	public boolean getIsBarred(){
		return isBarred;
	}
	/**
	 * Sets whether this math term should be negated (see Latex's \neg{}).
	 * @param isNegated
	 */
	public void setIsNegated(boolean isNegated){
		this.isNegated=isNegated;
	}
	/**
	 * isNegated getter.
	 * @return-True if this term should be negated.
	 */
	public boolean getIsNegated(){
		return isNegated;
	}
	/**
	 * This method should be implemented in any of MathTerm derivatives
	 *  (inheriting classes). 
	 * However, we will leave it unimplemented (returns empty string).
	 * @return
	 */
	public java.lang.String toLatex(){
		return null;
	}
	/**
	 * this method checks and prints the expression sent to it.
	 * it can print an exp,barred or negated expression.
	 * @param latex -the string that will be printed.
	 * @return the modified string.
	 */
	protected String latexPrint (String latex){
		if(this.isExp){
			latex= latex +"^{ " + this.exp.toLatex() + " }";
		}
		if(getIsBarred()){
			latex= "\\overline{ " + latex + " }";
		}
		if(getIsNegated()){
			latex= "\\neg{ " + latex + " }";
		}
		return latex;
	}
}
