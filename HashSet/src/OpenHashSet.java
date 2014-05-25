import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/**
 * a hash-set based on open-hashing with quadratic probing. Extends
SimpleHashSet.
 * @author isaacdelarosa
 *
 */
public class OpenHashSet extends SimpleHashSet {
	private static final int HASH_POWER_FACTOR = 2;
	private static final double OPEN_HASH_FACTOR = 0.5;
	private String[] openTable;
	private int size;
	private boolean containesBool=false;
	private boolean deleteBool;
	private boolean isExtanding=false;
	private static String deleted;
	private static final double increse=2.0,decrese=OpenHashSet.OPEN_HASH_FACTOR;
	/**
	 * A default constructor. Constructs a new, empty table with default 
	 * initial capacity (16), upper load factor (0.75) 
	 * and lower load factor (0.25).
	 */
	public OpenHashSet(){
		this(UPPER_LOAD_FACTOR,LOWER_LOAD_FACTOR);
	}
	/**
	 * Constructs a new, empty table with the specified load factors, and the
	 *  default initial capacity (16).
	 * @param upperLoadFactor The upper load factor of the hash table.
	 * @param lowerLoadFactor The lower load factor of the hash table.
	 */
	public OpenHashSet(float upperLoadFactor,
			float lowerLoadFactor){
		super(upperLoadFactor, lowerLoadFactor);
		size=0;
		this.openTable=new String[DEFAULT_CAPACITY];
	}
	/**
	 * Data constructor - builds the hash set by adding the elements 
	 * one by one. Duplicate values should be ignored. The new table has the
	 *  default values of initial capacity (16), upper load factor (0.75),
	 *   and lower load factor (0.25).
	 * @param data Values to add to the set.
	 */
	public OpenHashSet(java.lang.String[] data){
		this(UPPER_LOAD_FACTOR,LOWER_LOAD_FACTOR);	
		//add all strings one by one
		for (String str:data){
			add(str);
		}
	}
	/**
	 * Add a specified element to the set.
	 * @param newValue New value to add to the set

	 * @return False iff newValue already exists in the set
	 */
	public boolean add(java.lang.String newValue){
		//if the open table is only expanding there is no need to check for
		//double values so we can skip the contains check while we add strings.
		if(!isExtanding){
			if(this.contains(newValue)||newValue==null){
				return false;
			}
		}
		//find the cell index we want to add
		int indexFound=hashIndex(newValue, 1);
		openTable[indexFound]= newValue;
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
		size=0;
		int oldCapacity= this.capacity;
		capacity*=sizeFactor;//calculate the new size
		String tempTable[]=this.openTable.clone();//copies the old table
		this.openTable=new String[this.capacity];
		//adds old strings to new table with their new index
		for (int i = 0; i < oldCapacity; i++) {
			if(tempTable[i]!=null&&tempTable[i]!="deleted"){
				isExtanding=true;
				add(tempTable[i]);
			}
		}
		isExtanding=false;
	}
	/**
	 * calculates the hash code of the specific object by modulo.
	 * @param k the specific operation that should be performed,add/delete.
	 * @param data the data that needs to be inserted.
	 * @return
	 */
	private int hashIndex(Object data,int k){
		int i=0;
		int j=0;
		boolean found = false;//the loop condition.
		while(found == false) {
			//the open hash function : hashCode+0.5i+0.5i^2
			i=(int) Math.abs((data.hashCode()+
					OpenHashSet.OPEN_HASH_FACTOR*j+
					OpenHashSet.OPEN_HASH_FACTOR*
					Math.pow(j, OpenHashSet.HASH_POWER_FACTOR)))&
					(this.capacity()-1);
			j++;
			switch(k){
			case 1://add new string
				if((this.openTable[i]==null)
						|| (this.openTable[i].equals("deleted"))){
					found = true;
					break;//exit the loop and return the eligible cell
				}
				continue;//continue looking for the wanted cell
			case 2://delete the string
				if(openTable[i].equals(data)){
					//delete the string
					openTable[i]=null;
					//flag the cell so we can search the table.
					openTable[i]="deleted";
					found=true;
					deleteBool=true;
					break;//exit the loop and return the eligible cell
				}
				continue;//continue looking for the wanted cell
			}
		}	
		return i;//return i,the wanted cell(after all checks)
	}
	/**
	 * search for a given value through the table and return its location
	 * @param data the value to look for
	 * @return the value location
	 */
	private int hashSearch(Object data){
		int i=0;
		int j=0;
		boolean found = false;
		while(found==false){
			//the open hash function
			i=(int) Math.abs((data.hashCode()+
					OpenHashSet.OPEN_HASH_FACTOR*j+
					OpenHashSet.OPEN_HASH_FACTOR*
					Math.pow(j, HASH_POWER_FACTOR)))&
					(this.capacity()-1);
			j++;
			//stop searching if null is found.
			if(openTable[i]==null){
				found=false;
				this.containesBool=false;
				break;//exit the loop and return the eligible cell
			}
			if(openTable[i]!=null && openTable[i].equals(data)){
				found=true;
				this.containesBool=true;
				break;//exit the loop and return the eligible cell
			}
			continue;//continue looking for the wanted cell
		}
		return i;//return i the location if it exists.
	}
	/**
	 * 
	 * @return The current capacity (number of cells) of the table.
	 */
	public int capacity(){
		return this.capacity;
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
		hashSearch(searchVal);
		return this.containesBool;
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
		//find the cell index we want to delete
		int indexFound=hashIndex(toDelete, 2);
		size--;
		//checks if the table need to be smaller
		if((double)size/capacity<lowerLoadFactor){
			reHash(decrese);
		}
		return deleteBool;
	}
	/**
	 * 
	 * @return The number of elements currently in the set
	 */
	public int size(){
		return this.size;
	}
}
