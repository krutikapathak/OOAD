package heap;

import java.util.Scanner;

/**
 * 
 * @author krutikapathak
 *
 */
public class MinHeapInsert {
	static Node root;

	public static void main(String[] args) {
		int[] intArray = new int[] {45, 65, 72, 90, 81, 82, 96, 99, 95, 50}; //, 8, 7, 11, 7, 8, 90 , 10}; // , 5, 6, 6 };
		int i = 0;

		for (i = 0; i < intArray.length; i++) {
			root = insert(root, intArray[i]);
		}
		root.print2D(root);
	}

//	A min-heap is a heap in which the root has the smallest value in the heap. Normally one would
//	implement a heap using an array. In this assignment you are to use pointers, not an array. In
//	our min-heap each node has a value and 0, 1 or 2 children heaps. The root node of a minheap contains the smallest value in the heap. 
//	If you pick any node in the heap it has a value
//	that is equal to or less than all the nodes in either the left or right sub-heaps of the node. See
//	the figure 1 below for an example. To add a new value to the heap add it to the top of the
//	heap. If the heap is empty the new value becomes the root. If heap is not empty than the
//	smaller of the two values (current value in heap and the new value) is kept in the root. The
//	larger of the two values is added the sub-heap with the smallest height. If both sub-heaps have
//	the same height then the larger of the two values is added to the left heap. The process is
//	repeated until a value is added to a new node at the bottom of the heap

	private static Node insert(Node root, int num) {
		if (root == null) {
			root = new Node(num);
			return root;
		}
		if(root.val > num) {
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
