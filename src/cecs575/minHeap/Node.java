package cecs575.minHeap;

import java.util.List;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

// class to represent Nodes in min heap- Node attributes, height and traversal
public class Node {
	private Node left;
	private Node right;
	private int nodeVal;
	
	// Constructors
	public Node() {}
	
	public Node(int val) {
		this.nodeVal = val;
	}
	
	// getters for node class member variables
	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
	
	public int getNodeVal() {
		return nodeVal;
	}
	
	// setters for node class member variables
	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setNodeVal(int nodeVal) {
		this.nodeVal = nodeVal;
	}
	
	// method to find maximum of left or right sub-heap height 
	public int findMaxHeight(int lHeight, int rHeight) {
		if (lHeight >= rHeight)
			return lHeight;
		else
			return rHeight;
	}

	// method to find height for the given root
	public int findHeight(Node root) {
		if (root == null)
			return 0;

		return findMaxHeight(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
	}
	
	// method to traverse min heap
	public List<Integer> traverseMinHeap(Node node, String indicator, List<Integer> orderList) {
		if (node == null)
			return orderList;
		
		// Pre-order traversal of heap to fetch odd numbers
		if (indicator == "pre") {
			if (node.getNodeVal() % 2 != 0) {
				orderList.add(node.getNodeVal());
			}
		}

		traverseMinHeap(node.getLeft(), indicator, orderList);

		traverseMinHeap(node.getRight(), indicator, orderList);

		// Post-order traversal of heap
		if (indicator == "post") {
			orderList.add(node.getNodeVal());
		}

		return orderList;
	}
}
