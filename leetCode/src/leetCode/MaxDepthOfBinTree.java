package leetCode;

import javax.swing.RootPaneContainer;

public class MaxDepthOfBinTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	TreeNode root = new TreeNode(1);
	TreeNode left1 = new TreeNode(2);
	TreeNode right1 = new TreeNode(2);
	TreeNode left2 = new TreeNode(3);
	
	public MaxDepthOfBinTree() {
		root.left = left1;
		root.right = right1;
		left1.left = left2;
	}


	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		int a = maxDepth(root.left);
		int b = maxDepth(root.right);
		if(a>b) return a+1;
		else {
			return b + 1;
		}
	}
	
	public static void main(String args[]){
		MaxDepthOfBinTree test = new MaxDepthOfBinTree();
		System.out.println(test.maxDepth(test.root));
	}

}
