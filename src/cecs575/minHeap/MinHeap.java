package cecs575.minHeap;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

// class for min heap creation and printing the heap in pre/post order
public class MinHeap {

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		
		// input for Min Heap creation
		int[] intArray = new int[] { 45, 65, 72, 40, 90, 82, 81, 96, 99 };
		Node root = null;
		
		for (int i = 0; i < intArray.length; i++) {
			root = minHeap.insert(root, intArray[i]);
		}
		minHeap.fetchMinHeap(root);

		runTests();
	}

	// method to add integers to min heap
	public Node insert(Node root, int num) {
		if (root == null) {
			root = new Node(num);
			return root;
		}
		if (root.getNodeVal() > num) {
			num = swapNode(root, num);
		}
		
		// calculate left and right sub-heap heights
		int lHeight = root.findHeight(root.getLeft());
		int rHeight = root.findHeight(root.getRight());
		
		// insert integer in left sub-heap
		if (lHeight <= rHeight)
			root.setLeft(insert(root.getLeft(), num));
		
		// insert integer in right sub-heap
		else if (lHeight > rHeight) {
			root.setRight(insert(root.getRight(), num));
		}
		return root;
	}
	
	// method to swap larger root value with lesser value
	public int swapNode(Node root, int num) {
		int temp = root.getNodeVal();
		root.setNodeVal(num);
		num = temp;
		return num;
	}
	
	// method to fetch post order and pre order of min heap
	private void fetchMinHeap(Node root) {
		
		// fetch min heap in post order (left, right, root)
		System.out.println("\nPost order traversal of min heap: \n");
		List<Integer> orderList = root.traverseMinHeap(root, "post", orderList = new ArrayList<>());
		printMinHeap(orderList);
		
		// fetch odd numbers of min heap in pre order
		System.out.println("\nPre order traversal of min heap for odd numbers: \n");
		orderList = root.traverseMinHeap(root, "pre", orderList = new ArrayList<>());
		printMinHeap(orderList);
	}

	// method to print min heap in post and pre order
	private void printMinHeap(List<Integer> orderList) {
		for (Integer orderNum : orderList) {
			System.out.println(orderNum);
		}
	}
	
	// method to run JUnit tests
	private static void runTests() {
		Result result = JUnitCore.runClasses(MinHeapJUnitTestSuite.class);
		
		// handle failure
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		// handle success
		System.out.println("\nAll Tests successful: " + result.wasSuccessful());
	}
}
