/**
 * This class represents a term composed of exactly two independent math terms. 
 * Like MathTerm, this class functions as a base class and shouldn't be 
 * instantiated. 
 * Hence it has an unimplemented toLatex method (return "";).
 *  Classes that extending it should implement the toLatex method according
 *   to their own definition.
 * @author OOP
 *
 */
public class BinaryMathTerm extends MathTerm{
	public MathTerm _firstTerm;
	public MathTerm _secondTerm;
	/**
	 * Constructs an new BinaryMathTerm (should be called from within 
	 * extending classes).
	 * @param firstTerm-firstTerm.
	 * @param secondTerm-secondTerm.
	 */
	public BinaryMathTerm(MathTerm firstTerm,MathTerm secondTerm){
		_firstTerm=firstTerm;
		_secondTerm=secondTerm;
	}
	/**
	 * Unimplemented in this class. However, should be implemented in any of 
	 * its subclasses.
	 */
	public java.lang.String toLatex(){
		return null;
	}
}
