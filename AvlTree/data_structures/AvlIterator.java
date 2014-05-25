package oop.ex5.data_structures;

import java.util.Iterator;

import oop.ex5.data_structures.BinarySearchTree.Node;
/**
 * this class is an iterator that can iterate over a given tree's values.
 * @author isaacdelarosa
 *
 */
public class AvlIterator implements Iterator<Integer>{
	private Node current;
	private Node root;
	/**
	 * a constructor that builds a new iterable tree that starts from the 
	 * smallest value in the tree.
	 * @param node the root of the given tree that will become iterable.
	 */
	public AvlIterator (Node node){
		this.root=node;
		this.current=node;
		current=findMinNodes(current);//initiate the iterator from lowest val.
	}
	/**
	 * this method implements the hasnext iterator method and returns true iff
	 * the next val is not null.
	 */
	public boolean hasNext() {
		if(current!=null){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * this method implements the next iterator method and returns the next 
	 * integer value in the tree from min to max.
	 */
	public Integer next() {
		if(hasNext()){
			int currentVal=current.value;
			current= findSuccessor(current);
			return currentVal;
		}
		else{
			return null;
		}
	}
	/**
	 * this method implements the remove iterator method
	 */
	public void remove() {
		throw new UnsupportedOperationException();		
	}
	/**
	 * finds the smallest value in the tree
	 * @param n the trees root
	 * @return the node that holds the smallest val
	 */
	private static Node findMinNodes(Node n) {
		while (n.left != null){
			n = n.left;//go to the most left node if it exists
		}
		return n;
	}
	/**
	 * finds the given node successor in the tree.
	 * @param node the node we what to find its successor
	 * @return the successor
	 */
	public static Node findSuccessor(Node node)
	{
		if (node == null)
			return null;
		if (node.right != null)
			return findMinNodes(node.right);
		Node y = node.parent;
		Node x = node;
		while (y != null && x == y.right)
		{
			x = y;
			y = y.parent;
		}
		//  as we traverse  left up the tree we traverse smaller values
		// The first node on the right is the next larger number
		return y;
	}
}
