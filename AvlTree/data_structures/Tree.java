package oop.ex5.data_structures;
import java.util.Iterator;
/**
 * this is a generic tree interface.all of the tree have to implement these
 * following basic functions.
 * @author isaacdelarosa
 *
 */
public interface Tree {
	/**
	 * add new node with key newValue into the tree 
	 * @param newValue new value to add to the tree.
	 * @return false iff newValue already exist in the tree.
	 */
	public boolean add(int newValue);
	/**
	 * does tree contain a given input value
	 * @param searchVal value to search for
	 * @return if val is found in the tree ,return the depth of its node 
	 * (where 0 is the root).
	 * otherwise - return -1.
	 */
	public int contains (int searchVal);
	/**
	 * remove a node from the tree if it exist
	 * @param toDelete value to delete
	 * @return true iff toDelete is found and deleted. 
	 */
	public boolean delete (int toDelete);
	/**
	 * 
	 * @return number of nodes in the tree.
	 */
	public int size();
}
