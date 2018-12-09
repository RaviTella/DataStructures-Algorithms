package dataStructures.generalPurpose.trees.binary.search;

/*
 * @author Ravi Tella
 * Binary Search Tree using references 
 * 
 */
public class BinarySearchTreeByRef {
	Node root;

	public BinarySearchTreeByRef() {
		this.root = null;
	}

	public void insert(int key, String value) {
		Node nNode = new Node(key, value, null, null);
		if (root == null) {
			root = nNode;
		} else {
			Node cNode = root;
			while (true) {
				Node pNode = cNode; // saving the current node reference to
									// pNode
				if (nNode.key < cNode.key) {
					cNode = cNode.leftChild;
					if (cNode == null) { // reached vacant spot
						pNode.leftChild = nNode; // setting the new node as
													// pNode left Child
						return;
					}
				} else {
					cNode = cNode.rightChild;
					if (cNode == null) { // reached vacant spot
						pNode.rightChild = nNode; // setting the new node as
													// pNode right Child
						return;
					}
				}
			}
		}
	}

	public Node find(int key) {
		Node cNode;
		if (root == null) {
			return null;
		} else {
			cNode = root;
			while (cNode != null && cNode.key != key) {
				if (key < cNode.key) { // go left
					cNode = cNode.leftChild;
				} else { // go right
					cNode = cNode.rightChild;
				}
			}
		}
		return cNode;
	}

	public Node minimum() {
		Node cNode = null;
		if (root == null) {
			return null;
		} else {
			cNode = root;
			while (cNode.leftChild != null) { // keep going left till the left
												// child of a node is NULL
				cNode = cNode.leftChild;
			}
		}
		return cNode;
	}

	public Node maximum() {
		Node cNode = null;
		if (root == null) {
			return null;
		} else {
			cNode = root;
			while (cNode.rightChild != null) { // Keep going right till right
												// child of node is null
				cNode = cNode.rightChild;
			}
		}
		return cNode;
	}

	public void inOrderTraversal(String order) {
		if (order.equalsIgnoreCase("ascend")) {
			recursiveInOrderAscendTraversal(root);
		} else if (order.equalsIgnoreCase("dscend")) {
			recursiveInOrderDscendTraversal(root);
		}
	}

	private void recursiveInOrderAscendTraversal(Node cNode) {
		if (cNode != null) {
			recursiveInOrderAscendTraversal(cNode.leftChild);
			System.out.println(cNode.key);
			recursiveInOrderAscendTraversal(cNode.rightChild);
		}
	}

	private void recursiveInOrderDscendTraversal(Node cNode) {
		if (cNode != null) {
			recursiveInOrderDscendTraversal(cNode.rightChild);
			System.out.println(cNode.key);
			recursiveInOrderDscendTraversal(cNode.leftChild);
		}
	}

	public void displayTree() {

	}

}
