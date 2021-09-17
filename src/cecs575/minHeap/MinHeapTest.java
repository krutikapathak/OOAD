package cecs575.minHeap;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

// Test class for Min Heap
public class MinHeapTest {
	MinHeap minHeap = new MinHeap();
	
	// test to verify root insertion
	@Test
	public void testInsertRoot() {
		int num = 25;
		
		assertEquals(25, minHeap.insert(null, num).getNodeVal());
	}
	
	// test to verify left child insertion
	@Test
	public void testInsertLeft() {
		Node root = new Node(25);
		int num = 30;
		
		assertEquals(30, minHeap.insert(root, num).getLeft().getNodeVal());
	}
	
	// test to verify right child insertion
	@Test
	public void testInsertRight() {
		Node root = new Node(25);
		Node left = new Node(30);
		root.setLeft(left);
		int num = 40;
		
		assertEquals(40, minHeap.insert(root, num).getRight().getNodeVal());
	}
	
	// test to verify root returned is not null
	@Test
	public void testInsertNotNull() {
		assertNotNull(minHeap.insert(null, 20));
	}
	
	// test to verify insertion of negative number in the heap
	@Test
	public void testInsertNegNo() {
		Node root = new Node(-2);
		assertEquals(-2, minHeap.insert(root, 10).getNodeVal());
	}
	
	// test to verify swapping of larger root value with smaller value
	@Test
	public void testSwapNode() {
		Node root = new Node(10);
		assertEquals(10, minHeap.swapNode(root, 20));
	}
	
	// test to verify swapped value insertion
	@Test
	public void testInsertSwap() {
		Node root = new Node(10);
		assertEquals(5, minHeap.insert(root, 5).getNodeVal());
	}

}
