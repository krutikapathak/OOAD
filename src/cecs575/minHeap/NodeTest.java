package cecs575.minHeap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Team members: Krutika Pathak(026737072) and Shiva Singh(026774434)
 *
 */

//Test class for Node
public class NodeTest {
	Node node = new Node();
	
	// test to verify the calculation of maximum height
	@Test
	public void testFindMaxHeight() {
		assertEquals(4, node.findMaxHeight(3, 4));
	}
	
	// test to verify the correctness of left sub-heap height
	@Test
	public void testFindHeightLeft() {
		Node root = new Node(10);
		Node left = new Node(20);
		root.setLeft(left);
		assertEquals(1, node.findHeight(root.getLeft()));
	}
	
	// test to verify the correctness of right sub-heap height
	@Test
	public void testFindHeightRight() {
		Node root = new Node(10);
		Node first = new Node(20);
		Node second = new Node(25);
		Node third = new Node(30);
		root.setLeft(first);
		root.setRight(second);
		root.getRight().setLeft(third);
		assertEquals(2, node.findHeight(root.getRight()));
	}
	
	// test to verify the correctness of min-heap height
	@Test
	public void testFindHeight() {
		Node root = new Node(10);
		Node first = new Node(20);
		Node second = new Node(25);
		Node third = new Node(30);
		Node fourth = new Node(35);
		Node fifth = new Node(40);
		root.setLeft(first);
		root.setRight(second);
		root.getLeft().setLeft(third);
		root.getLeft().setRight(fourth);
		root.getRight().setLeft(fifth);
		assertEquals(3, node.findHeight(root));
	}
	
	// test to verify the correctness of post order traversal
	@Test
	public void testPostOrder() {
		Node root = new Node(10);
		Node first = new Node(20);
		Node second = new Node(25);
		root.setLeft(first);
		root.setRight(second);
		
		List<Integer> postOrderList = new ArrayList<>();
		List<Integer> orderList = new ArrayList<>();
		postOrderList.add(20);
		postOrderList.add(25);
		postOrderList.add(10);
		
		orderList = node.traverseMinHeap(root, "post", orderList);
		for(int i=0; i<orderList.size(); i++) {
			assertEquals(postOrderList.get(i), orderList.get(i));
		}
	}
	
	// test to verify the correctness of pre order traversal for odd numbers
	@Test
	public void testPreOrder() {
		Node root = new Node(10);
		Node first = new Node(25);
		Node second = new Node(35);
		root.setLeft(first);
		root.setRight(second);
		
		List<Integer> preOrderList = new ArrayList<>();
		List<Integer> orderList = new ArrayList<>();
		preOrderList.add(25);
		preOrderList.add(35);
		
		orderList = node.traverseMinHeap(root, "pre", orderList);
		for(int i=0; i<orderList.size(); i++) {
			assertEquals(preOrderList.get(i), orderList.get(i));
		}
	}
}
