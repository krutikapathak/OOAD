package heap;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh()
 *
 */
public class MinHeapInsert {
	static Node root;

	public static void main(String[] args) {
//		int[] intArray = new int[] {45, 65, 72, 90, 81, 82, 96, 99, 95, 50};
		int[] intArray = new int[] { 45, 65, 72, 90, 82, 81, 96, 99 };
		int i = 0;

		for (i = 0; i < intArray.length; i++) {
			root = insert(root, intArray[i]);
		}
		root.drawTree(root, 0);

		System.out.println("Post order traveral of min heap: \n");
		root.postOrder(root);
		System.out.println("\n\nPre order of min heap for odd numbers: \n");
		root.preOrder(root);

	}

	private static Node insert(Node root, int num) {
		if (root == null) {
			root = new Node(num);
			return root;
		}
		if (root.val > num) {
			num = swapNode(root, num);
		}
		int lHeight = root.findHeight(root.left);
		int rHeight = root.findHeight(root.right);
		if (lHeight <= rHeight)
			root.left = insert(root.left, num);
		else if (lHeight > rHeight) {
			root.right = insert(root.right, num);
		}
		return root;
	}

	private static int swapNode(Node root, int num) {
		int temp = root.val;
		root.val = num;
		num = temp;
		return num;
	}
}
