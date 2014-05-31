/**
 * A superclass for implementations of hash-sets implementing the SimpleSet
 *  interface.
 */
public abstract class SimpleHashSet implements SimpleSet {
	//all of the protected variables will be used in the child classes
	protected static final int DEFAULT_CAPACITY=16;
	protected static final float UPPER_LOAD_FACTOR=(float) 0.75;
	protected static final float LOWER_LOAD_FACTOR=(float) 0.25;
	protected float upperLoadFactor;
	protected float lowerLoadFactor;
	protected int capacity;
	public SimpleHashSet(){
		this.upperLoadFactor=UPPER_LOAD_FACTOR;
		this.lowerLoadFactor=LOWER_LOAD_FACTOR;
	}
	/**
	 * the constructor that creates the table with specific load factors
	 * @param upperLoadFactor
	 * @param lowerLoadFactor
	 */
	public SimpleHashSet(float upperLoadFactor,
			float lowerLoadFactor){
		this.upperLoadFactor=upperLoadFactor;
		this.lowerLoadFactor=lowerLoadFactor;
		this.capacity=DEFAULT_CAPACITY;
	}
	/**
	 * 
	 * @return The current capacity (number of cells) of the table.
	 */
	public abstract int capacity();
}
