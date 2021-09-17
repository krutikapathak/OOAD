package heap;

import java.util.List;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

public class Node {
	private Node left;
	private Node right;
	private int nodeVal;
	static final int count = 10;
	
	public Node() {}
	
	public Node(int val) {
		this.nodeVal = val;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getNodeVal() {
		return nodeVal;
	}

	public void setNodeVal(int nodeVal) {
		this.nodeVal = nodeVal;
	}

	public int findMax(int lHeight, int rHeight) {
		if (lHeight >= rHeight)
			return lHeight;
		else
			return rHeight;
	}

	public int findHeight(Node root) {
		if (root == null)
			return 0;

		return findMax(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
	}

	public List<Integer> prePostOrder(Node node, String indicator, List<Integer> orderList) {
		if (node == null)
			return orderList;

		if (indicator == "pre") {
			if (node.getNodeVal() % 2 != 0) {
				orderList.add(node.getNodeVal());
			}
		}

		prePostOrder(node.getLeft(), indicator, orderList);

		prePostOrder(node.getRight(), indicator, orderList);

		if (indicator == "post") {
			orderList.add(node.getNodeVal());
		}

		return orderList;
	}

	public void drawTree(Node root, int space) {
		if (root == null)
			return;

		space += count;

		drawTree(root.getRight(), space);

		System.out.print("\n");
		for (int i = count; i < space; i++)
			System.out.print(" ");
		System.out.print(root.getNodeVal() + "\n");

		drawTree(root.getLeft(), space);
	}
}
