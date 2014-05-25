package oop.ex5.data_structures;
import java.util.Iterator;

import oop.ex5.data_structures.BinarySearchTree.Node;

public class AvlTree extends BinarySearchTree{
	private static final int MAX_DIFFERANCE_VALUE = 2;
	boolean inserted=false;
	/**
	 * A default constructor. */
	public AvlTree(){
		super();//same initialization as BST
	}
	/**
	 * *  A data constructor 
	 *  a constructor that builds the tree by adding the elements in the 
	 * input array one-by-one. 
	 * If the same value appears twice (or more) in the list, it is ignored.
	 *@param data values to add to tree 
	 * @return 
	 */
	public AvlTree(int[] data){
		super();
		for (int i = 0; i < data.length; i++) {
			add(data[i]);//add all vals in data to crate new AVL tree
		}
	}
	/**
	 * A copy constructor-
	 * a constructor that builds the tree a copy of an existing tree
	 * @param tree an AVL tree
	 */
	public AvlTree(AvlTree tree){
		super();
		Iterator<Integer> itr=tree.iterator();
		while(itr.hasNext()){
			int next=itr.next();
			add(next);//add all vals in the given tree to crate new AVL tree
		}
	}
	private Node root = null;//"restart" tree
	/**
	 * add new node with key NewValue to the tree
	 * @param newValue new value to add to the tree
	 * @return false iff newValue already exist in the tree.
	 */
	public boolean add(int newValue) {
		return(insert(root, newValue));
	}
	/**
	 * actually inserts the new val to the avl tree. also checks if the tree 
	 * is balanced after inserting the val.
	 * @param node the root of the avl tree that we want to add a node to
	 * @param value the value that will be inserted
	 * @return true iff we added the val
	 */
	private boolean insert(Node node, int value) {
		if (root == null) {//first node insertion
			root = new Node(value, null);
			this.size++;//we increse the trees size every time we add a new 
			//node
			return true;
		}
		if(value==node.value){
			return false;//node already exist.
			//no need to reheight because we dont add new node
		}

		if (value < node.value) {//if val is smaller go left
			if (node.left != null) {
				insert(node.left, value);//if already taken continue trying
			} else {
				node.left = new Node(value, node);
				this.size++;
			}
			// check if left branch is heavier after inserting
			if (super.height(node.left) - super.height(node.right) ==
					AvlTree.MAX_DIFFERANCE_VALUE) { 
				if (value < node.left.value) {
					rotateRight(node);
				} else {
					rotateLeftThenRight(node);
				}
			}
		} else if (value > node.value) {//if val is smaller go right
			if (node.right != null) {
				insert(node.right, value);//if already taken continue trying
			} else {
				node.right = new Node(value, node);
				this.size++;
			}
			// check if right branch is heavier after inserting
			if (super.height(node.right) - super.height(node.left) ==
					AvlTree.MAX_DIFFERANCE_VALUE) { 
				if (value > node.right.value)
					rotateLeft(node);
				else {
					rotateRightThenLeft(node);
				}
			}
		}
		reHeight(node);//fix all nods heights
		return true;
	}
	/**
	 * right node rotation same as we learned in data structures course
	 * @param pivot the node that is actually make the rotation on.
	 */
	private void rotateRight(Node pivot) {
		Node parent = pivot.parent;
		Node leftChild = pivot.left;
		Node rightChildOfLeftChild = leftChild.right;
		pivot.setLeftChild(rightChildOfLeftChild);
		leftChild.setRightChild(pivot);
		//relocate all relevant nodes
		if (parent == null) {
			this.root = leftChild;
			leftChild.parent = null;
			return;
		}
		if (parent.left == pivot) {
			parent.setLeftChild(leftChild);
		} else {
			parent.setRightChild(leftChild);
		}
		reHeight(pivot);
		reHeight(leftChild);
	}
	/**
	 * left node rotation same as we learned in data structures course
	 * @param pivot the node that is actually make the rotation on.
	 */
	private void rotateLeft(Node pivot) {
		Node parent = pivot.parent;
		Node rightChild = pivot.right;
		Node leftChildOfRightChild = rightChild.left;
		pivot.setRightChild(leftChildOfRightChild);
		rightChild.setLeftChild(pivot);
		if (parent == null) {
			//relocate all relevant nodes
			this.root = rightChild;
			rightChild.parent = null;
			return;
		}
		if (parent.left == pivot) {
			parent.setLeftChild(rightChild);
		} else {
			parent.setRightChild(rightChild);
		}
		reHeight(pivot);
		reHeight(rightChild);
	}
	/**
	 *  special case of double rotation in the case of zigzag that requires 
	 *  rotating twice(right branch is heavier than left branch becomes heavier)
	 *   so the tree will be balanced.
	 * @param node the node that will be rotated
	 */
	private void rotateLeftThenRight(Node node) {
		rotateLeft(node.left);
		rotateRight(node);
	}
	/**
	 *  special case of double rotation in the case of zigzag that requires 
	 *  rotating twice(left branch is heavier than right branch becomes 
	 *   heavier) so the tree will be balanced.
	 * @param node the node that will be rotated
	 */
	private void rotateRightThenLeft(Node node) {
		rotateRight(node.right);
		rotateLeft(node);
	}
	/**
	 * remove a node from the tree if it exist.
	 * @param toDelete value to delete
	 * @return true iff toDelete is found and deleted
	 */
	public boolean delete(int toDelete) {
		Node target = search(toDelete);//look for the node containing the val
		//that will be deleted
		if (target == null) return false;
		target = deleteNode(target);
		if(target!=null){
			balanceTree(target.parent);
		}
		this.size--;//Decrease size after removing a node 
		return true;
	}
	/**
	 * this method actually deletes the node with all required balance checks.
	 * @param target the node that needs to be deleted
	 * @return true iff toDelete is found and deleted
	 */
	private Node deleteNode(Node target) {
		if(target.parent==null&&target.left==null&&target.right==null){
			target=null;
			return target;
		}
		if (isLeaf(target)) { //leaf case
			if (isLeftChild(target)) {
				target.parent.left = null;
			} else {
				target.parent.right = null;
			}
			//exact 1 child case
			//only one of the following cases
		} else if (target.left == null ^ target.right == null) { 
			Node nonNullChild =
					target.left == null ? target.right : target.left; 
			if (isLeftChild(target)) {
				target.parent.setLeftChild(nonNullChild); 
			} else {
				target.parent.setRightChild(nonNullChild);
			}
			//2 children case
		} else {
			Node preInOrder = preInOrder(target);
			target.value = preInOrder.value;
			target = deleteNode(preInOrder);
		}
		reHeight(target.parent);
		return target;
	}
	/**
	 * shifts and moves the sons to their new location
	 * @param node the node we want to shift
	 * @return the current node we just moved
	 */
	private Node preInOrder(Node node) {
		Node current = node.right;
		while (current.left != null) {
			current = current.left;
		}

		return current;
	}

	/**
	 * calculate the difference in the children's heights,for balancing.
	 * a positive dif means right branch is heavier,and negative dif 
	 * means left branch is heavier
	 * @param node the father we want to check
	 * @return the  difference in heights.
	 */
	private int calDifference(Node node) {
		int rightHeight = super.height(node.right);
		int leftHeight = super.height(node.left);
		return rightHeight - leftHeight;
	}
	/**
	 * balance the tree in case the difference in heights is 2 or more
	 * @param node the local root that will be balanced
	 */
	private void balanceTree(Node node) {
		int difference = calDifference(node);
		Node parent = node.parent;
		//if left branch is heavier
		if (difference == -AvlTree.MAX_DIFFERANCE_VALUE) {
			if (super.height(node.left.left) >=
					super.height(node.left.right)) {
				rotateRight(node);
			} else {
				rotateLeftThenRight(node);
			}
			//if right branch is heavier
		} else if (difference == AvlTree.MAX_DIFFERANCE_VALUE) {
			if (super.height(node.right.right) >=
					super.height(node.right.left)) {
				rotateLeft(node);
			} else {
				rotateRightThenLeft(node);
			}
		}

		//Recursively balance all roots in the tree so the whole tree
		//will be balanced 
		if (parent != null) {
			balanceTree(parent);
		}

		reHeight(node);
	}

	/**
	 * does tree contain a given input value
	 * @param searchVal value to search for
	 * @return if val is found in the tree ,return the depth of its node 
	 * (where 0 is the root).
	 * otherwise - return -1.
	 */
	@Override
	public int contains(int searchVal) {
		//look for node using binary search inherited from the BST class
		Node nodeFound=binarySearch(root, searchVal);
		if(nodeFound!=null){
			return depth(nodeFound);
		}
		else{//case not found
			return -1;
		}
	}
	/**
	 * calculates the nods depth by counting how many times it takes to
	 *  get to the root
	 * @param node the node we want to know its depth
	 * @return the nodes depth
	 */
	private int depth(Node node){
		int c=0;
		while(node!=null&& node.parent!=null){//while we didnt reach the root
			node=node.parent;
			c++;
		}
		return c;
	}
	/**
	 * looks for a given value in the tree using BST binary search
	 * @param key the val we want to look for
	 * @return the node that holds this val
	 */
	private Node search(int key) {
		return binarySearch(root, key);
	}

	public void traverseInOrder() {
		System.out.println("ROOT " + root.toString());
		inorder(root);
		System.out.println();
	}

	private void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.toString());
			inorder(node.right);
		}
	}
	/**
	 * @return iterator to the AVL tree. the returned iterator can pass over 
	 * the trees node in ascending order.
	 */
	public Iterator<Integer> iterator() {
		return (new AvlIterator(this.root));//uses separate class

	}
	/**
	 * this method calculated the min number of nodes in an AVL tree of height h.
	 * @param h height of the tree (a non negative number)
	 * @return the min nodes in the tree.
	 */
	public static int findMinNodes(int h){
		return minAvl(h-1,0);
	}
	/**
	 * return the minimal number of nodes in an AVL Tree
	 * @param height the avl tree height
	 * @param minAvlNode the root
	 * @return the minimal number of nodes in this AVL Tree
	 */
	private static int minAvl(int height, int minAvlNode){
		if(height==0)
			return minAvlNode;
		//calculating using fibonacci as studies in DAST
		minAvlNode+=fibonacci(height-1);
		return minAvl(height-1, minAvlNode);
	}
	/**
	 * calculate the fibonacci number of an index of the series
	 * @param n the n'th fibonacci number
	 */
	private static int fibonacci(int n){
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		//recursive calculation by the formula
		return fibonacci(n-1) + fibonacci(n-AvlTree.MAX_DIFFERANCE_VALUE);
	}

}