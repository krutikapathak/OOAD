package heap;

public class Node {
		Node left;
		Node right;
		Node parent;
		int val;
		static final int COUNT = 10;
		
		public Node(int val) {
			this.val = val;
		}
		
		int findMax(int a, int b){
		    if(a >= b)
		      return a;
		    else
		      return b;
		  }
		
		int findHeight(Node root){
		    if(root == null)
		      return 0;

		    return findMax(findHeight(root.left), findHeight(root.right)) + 1;
		  }
		
//		int findLeftHeight(Node root){
//		    if(root == null)
//		      return 0;
//
//		    return (findLeftHeight(root.left)) + 1;
//		  }
//		
//		int findRightHeight(Node root){
//		    if(root == null)
//		      return 0;
//
//		    return (findRightHeight(root.right)) + 1;
//		  }
		
		static void print2DUtil(Node root, int space)
		{
		    // Base case
		    if (root == null)
		        return;
		 
		    // Increase distance between levels
		    space += COUNT;
		 
		    // Process right child first
		    print2DUtil(root.right, space);
		 
		    // Print current node after space
		    // count
		    System.out.print("\n");
		    for (int i = COUNT; i < space; i++)
		        System.out.print(" ");
		    System.out.print(root.val + "\n");
		 
		    // Process left child
		    print2DUtil(root.left, space);
		}
		 
		// Wrapper over print2DUtil()
		static void print2D(Node root)
		{
		    // Pass initial space count as 0
		    print2DUtil(root, 0);
		}
}
