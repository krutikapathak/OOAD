package heap;

public class Node {
	Node left;
	Node right;
	int val;
	static final int count = 10;

	public Node(int val) {
		this.val = val;
	}

	int findMax(int a, int b) {
		if (a >= b)
			return a;
		else
			return b;
	}

	int findHeight(Node root) {
		if (root == null)
			return 0;

		return findMax(findHeight(root.left), findHeight(root.right)) + 1;
	}

	void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);

		postOrder(node.right);

		System.out.print(node.val + " ");
	}

	void preOrder(Node node) {
		if (node == null)
			return;

		if (node.val % 2 != 0) {
			System.out.print(node.val + " ");
		}

		preOrder(node.left);

		preOrder(node.right);
	}

	static void drawTree(Node root, int space) {
		if (root == null)
			return;

		space += count;

		drawTree(root.right, space);

		System.out.print("\n");
		for (int i = count; i < space; i++)
			System.out.print(" ");
		System.out.print(root.val + "\n");

		drawTree(root.left, space);
	}
}
