import java.util.*;

/**
 * a hash-set based on chaining. Extends SimpleHashSet.
 * @author isaacdelarosa
 *
 */
public class ChainedHashSet extends SimpleHashSet {
	protected ArrayList<LinkedList<String>> chainedTable;
	private int size;
	private static final double increse=2.0,decrese=0.5;
	/**
	 * A default constructor. Constructs a new, empty table with default
	 *  initial capacity (16), upper load factor (0.75) and 
	 *  lower load factor (0.25).
	 */
	public ChainedHashSet(){
		this(UPPER_LOAD_FACTOR,LOWER_LOAD_FACTOR);
	}
	/**
	 * Constructs a new, empty table with the specified load factors, and the
	 *  default initial capacity (16).
	 * @param upperLoadFactor  The upper load factor of the hash table.
	 * @param lowerLoadFactor The lower load factor of the hash table.
	 */
	public ChainedHashSet(float upperLoadFactor,
			float lowerLoadFactor){
		super(upperLoadFactor,lowerLoadFactor);
		size=0;
		//creates new chainedHash with a linked list of array lists.
		this.chainedTable=
				new ArrayList<LinkedList<String>>(this.DEFAULT_CAPACITY);
		for(int i=0;i<this.capacity;i++){
			chainedTable.add(new LinkedList<String>());
		}
	}
	/**
	 * Data constructor - builds the hash set by adding the elements one by
	 *  one. Duplicate values should be ignored. The new table has the default
	 *   values of initial capacity (16), upper load factor (0.75), and lower
	 *    load factor (0.25).
	 * @param data Values to add to the set.
	 */
	public ChainedHashSet(java.lang.String[] data){
		this(UPPER_LOAD_FACTOR,LOWER_LOAD_FACTOR);		
		for (String str:data){//add all strings one by one
			add(str);
		}
	}
	/**
	 * Add a specified element to the set.
	 * @param newValue New value to add to the set
	 * @return False iff newValue already exists in the set
	 */
	public boolean add(java.lang.String newValue){
		if(this.contains(newValue)||newValue==null){
			return false;
		}
		chainedTable.get(hashIndex(newValue)).addLast(newValue);
		size++;
		//checks if the table need to be bigger
		if((double)size/capacity>upperLoadFactor){
			reHash(increse);
		}
		return true;
	}
	/**
	 * rehashing the current table due to load factor.
	 * @param sizeFactor the factor of decreasing or increasing table.
	 */
	private void reHash(double sizeFactor){
		ArrayList<LinkedList<String>> tempTable
		=new ArrayList<LinkedList<String>>(capacity);
		capacity*=sizeFactor;
		for(int i =0; i<chainedTable.size();i++)//copy the current table
		{
			if(!chainedTable.get(i).equals("deleted")){
				tempTable.add(i,chainedTable.get(i));
			}
		}
		chainedTable=new ArrayList<LinkedList<String>>(capacity);
		for(int i=0;i<capacity;i++){
			chainedTable.add(new LinkedList<String>());
		}
		//adds old strings to new resized table one by one with their new
		//location
		for(LinkedList<String> myList:tempTable){
			for(String str:myList){
				chainedTable.get(hashIndex(str)).addLast(str);
			}
		}
	}
	/**
	 * 
	 * @return The current capacity (number of cells) of the table.
	 */
	public int capacity(){
		return this.capacity;
	}
	/**
	 * calculates the hash code of the specific object by modulo.
	 * @param data the data that needs to be inserted.
	 * @return
	 */
	private int hashIndex(Object data){
		return Math.abs(data.hashCode()&(capacity()-1));
	}
	/**
	 * Look for a specified value in the set.
	 * @param searchVal Value to search for
	 * @return True iff searchVal is found in the set
	 */
	public boolean contains(java.lang.String searchVal){
		if(searchVal==null){
			return false;
		}
		return chainedTable.get(hashIndex(searchVal)).contains(searchVal);
	}
	/**
	 * Remove the input element from the set.
	 * @param toDelete Value to delete
	 * @return True iff toDelete is found and deleted
	 */
	public boolean delete(java.lang.String toDelete){
		if(!this.contains(toDelete)||toDelete==null){
			return false;
		}
		//if wasnt able to delete because toDelete dosnt exist
		if(!chainedTable.get(hashIndex(toDelete)).remove(toDelete)){
			return false;
		}
		size--;
		//checks if the table need to be smaller
		if((double)size/capacity<lowerLoadFactor){
			reHash(decrese);
		}
		return true;
	}
	/**
	 * 
	 * @return The number of elements currently in the set
	 */
	public int size(){
		return this.size;
	}
}
