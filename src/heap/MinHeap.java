package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */
public class MinHeap {

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		int[] intArray = new int[] { 45, 65, 72, 40, 90, 82, 81, 96, 99 };
		Node root = null;

		for (int i = 0; i < intArray.length; i++) {
			root = minHeap.insert(root, intArray[i]);
		}
		root.drawTree(root, 0);
		minHeap.prePostTraversal(root);
	}

	public Node insert(Node root, int num) {
		if (root == null) {
			root = new Node(num);
			return root;
		}
		if (root.getNodeVal() > num) {
			num = swapNode(root, num);
		}
		int lHeight = root.findHeight(root.getLeft());
		int rHeight = root.findHeight(root.getRight());
		if (lHeight <= rHeight)
			root.setLeft(insert(root.getLeft(), num));
		else if (lHeight > rHeight) {
			root.setRight(insert(root.getRight(), num));
		}
		return root;
	}

	public int swapNode(Node root, int num) {
		int temp = root.getNodeVal();
		root.setNodeVal(num);
		num = temp;
		return num;
	}

	private void prePostTraversal(Node root) {
		System.out.println("\nPost order traveral of min heap: \n");
		List<Integer> orderList = root.prePostOrder(root, "post", orderList = new ArrayList<>());
		printList(orderList);

		System.out.println("\nPre order of min heap for odd numbers: \n");
		orderList = root.prePostOrder(root, "pre", orderList = new ArrayList<>());
		printList(orderList);
	}

	private void printList(List<Integer> orderList) {
		for (Integer orderNum : orderList) {
			System.out.println(orderNum);
		}
	}
}
