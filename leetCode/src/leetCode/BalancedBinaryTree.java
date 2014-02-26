package leetCode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
    	if (root == null) {
			return true;
		}else {
			int left = getDepth(root.left);
			int right = getDepth(root.right);
			if (left - right > 1 || right - left > 1) {
				return false;
			}else {
				return isBalanced(root.left)&&isBalanced(root.right);
			}
		}
    }
    
    public int getDepth(TreeNode root){
    	if (root == null) {
			return 0;
		}else if (root.left == null) {
			return getDepth(root.right)+1;
		}else if (root.right == null){
			return getDepth(root.left)+1;
		}else {
			int left = getDepth(root.left);
			int right = getDepth(root.right);
			return (left > right ? left: right) +1;
		}
    }
    
    public static void main(String []args){
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(1);
    	TreeNode node3 = new TreeNode(1);
    	TreeNode node4 = new TreeNode(1);
    	TreeNode node5 = new TreeNode(1);
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	node3.left = node5;
    	System.out.println(new BalancedBinaryTree().isBalanced(node3));
    }
    
}
