package oop.ex5.data_structures;



public abstract class BinarySearchTree implements Tree {
	protected Node root;
	boolean searchingDeeper=false;
	protected int size=0;
	private static Node parent;
	protected Node modifedNode;
	protected Node deleteNodeFound;
	protected int modifiedVal;
	public BinarySearchTree(){
		this.root=null;
	}

	/**
	 * constructs a new binary tree 
	 * @param data the data we want to create a BST from
	 */
	public BinarySearchTree(int[] data){
		if(data!=null){
			this.root=new Node(data[0], null);
			this.size=1;

			for (int i = 1; i < data.length; i++) {

				add(data[i]);
			}	
		}

	}
	/**
	 * this nested class is able to create nodes that have left and right 
	 * Children. 
	 * @author isaacdelarosa
	 *
	 */
	protected static class Node {
		Node left, right;
		Node parent;
		int value ;
		int height = 0;
		int depth=0;
		/**
		 * class constructor creates new node and connects it to its parent
		 * @param data the int value that will be stored in this node.
		 * @param parent this nodes parent 
		 */
		public Node(int data, Node parent) {
			this.value = data;
			this.parent = parent;
		}

		/**
		 * prints the BST
		 */
		@Override
		public String toString() {
			return value + " height " + height + " parent " +
					(parent == null ?
							"NULL" : parent.value) + " | ";
		}
		/**
		 * sets the node to be a left child
		 * @param child the node that will be entitled as left child
		 */
		void setLeftChild(Node child) {
			if (child != null) {
				child.parent = this;
			}

			this.left = child;
		}
		/**
		 * sets the node to be a right child
		 * @param child the node that will be entitled as right child
		 */
		void setRightChild(Node child) {
			if (child != null) {
				child.parent = this;
			}

			this.right = child;
		}
	}

	/**
	 * return the nodes height.used in AVL class
	 * @param node the node we want its height
	 * @return the nodes height
	 */
	protected int height(Node node) {
		return node == null ? -1 : node.height;
	}
	/**
	 * add new node with key newValue into the tree 
	 * @param newValue new value to add to the tree.
	 * @return false iff newValue already exist in the tree.
	 */
	@Override
	public boolean add(int newValue) {

		return add(root, newValue);


	}
	/**
	 * the method that actually adds the node
	 * @param node the root
	 * @param newValue the val to be inserted
	 * @return true iff inserted
	 */
	protected boolean add(Node node, int newValue) {
		boolean inserted = false;
		modifedNode=node;
		modifiedVal=newValue;
		//dont add if already exists
		if(newValue==node.value){
			//no need to reheight because we dont add new node
			return false;
		}
		//add to left branch if smaller
		if(newValue<node.value){
			inserted= addLeft(node,newValue);

		}
		//add to right branch if bigger
		else if(newValue>node.value){
			inserted= addRight(node, newValue);
		}

		reHeight(node);
		return inserted;
	}
	/**
	 * adds the node to left branch
	 * @param node the local root
	 * @param newValue the val to be inserted
	 * @return true iff inserted
	 */
	protected boolean addLeft(Node node,int newValue){
		if (node.left != null) {
			return add(node.left, newValue);
		} else {
			node.left = new Node(newValue, node);

			this.size++;

			return true;
		}
	}
	/**
	 * adds the node to right branch
	 * @param node the local root
	 * @param newValue the val to be inserted
	 * @return true iff inserted
	 */
	protected boolean addRight(Node node,int newValue){
		if (node.right != null) {
			return add(node.right, newValue);
		} else {
			node.right = new Node(newValue, node);
			this.size++;
			return true;
		}
	}

	/**
	 * an algorithm that calculates the nodes height by taking tha max height
	 * between the children and adding 1 (father is +1 higher).    
	 * @param node the father node
	 */
	protected void reHeight(Node node) {

		node.height = Math.max(height(node.left), height(node.right)) + 1;

	}
	/**
	 * search for a value through the given tree binary
	 * @param node the given trees root
	 * @param key the val we are looking for
	 * @return the node that holds this val
	 */
	protected Node binarySearch(Node node, int key) {
		if (node == null) return null;
		//base case
		if (key == node.value) {
			return node;
		}
		//smaller vals are stored in left subtree
		if (key < node.value && node.left != null) {
			return binarySearch(node.left, key);
		}
		//bigger vals are stored in right subtree
		if (key > node.value && node.right != null) {
			return binarySearch(node.right, key);
		}
		//if does not exist
		return null;
	}
	/**
	 * remove a node from the tree if it exist.no balancing is needed in BST!
	 * @param toDelete value to delete
	 * @return true iff toDelete is found and deleted. 
	 */
	@Override
	public boolean delete(int toDelete) {
		deleteNodeFound=binarySearch(root, toDelete);
		if(deleteNodeFound==null) return false;
		deleteNodeFound = deleteNode(deleteNodeFound);
		return true;
	}
	/**
	 * this method actually deletes the node with all required balance checks.
	 * @param target the node that needs to be deleted
	 * @return true iff toDelete is found and deleted
	 */
	private Node deleteNode(Node target) {
		if (isLeaf(target)) { //leaf
			if (isLeftChild(target)) {
				target.parent.left = null;
			} else {
				target.parent.right = null;
			}
			//exact 1 child case
			//only one of the following cases
		} else if (target.left == null ^ target.right == null) { 
			Node nonNullChild = target.left ==
					null ? target.right : target.left; 
			if (isLeftChild(target)) {
				target.parent.setLeftChild(nonNullChild); 
			} else {
				target.parent.setRightChild(nonNullChild);

			}
		} else {//2 children
			Node immediatePredInOrder = immediatePredInOrder(target);
			target.value = immediatePredInOrder.value;
			target = deleteNode(immediatePredInOrder);
		}
		if(modifedNode.parent!=null){
			reHeight(target.parent);
		}
		else{
			reHeight(modifedNode);

		}
		return target;
	}
	/**
	 * shifts and moves the sons to their new location
	 * @param node the node we want to shift
	 * @return the current node we just moved
	 */
	private Node immediatePredInOrder(Node node) {
		Node current = node.right;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	/**
	 * checks if the given child is a leaf
	 * @param node we want to check
	 * @return true if its a leaf
	 */
	protected boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
	/**
	 * checks if the given child is a left child
	 * @param child the child we want to check
	 * @return true if its a left child indeed.
	 */
	protected boolean isLeftChild(Node child) {

		return (child.parent.left == child);
	}
	/**
	 * 
	 * @return number of nodes in the tree.
	 */
	@Override
	public int size() {
		return this.size;
	}
	//this contains abstract will be implemented in the AVL class
	abstract public int contains(int searchVal);
}






