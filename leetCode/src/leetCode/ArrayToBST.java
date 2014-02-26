package leetCode;

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
    	if (num.length==0) {
			return null;
		}
		return toBST(num, 0, num.length-1);
    }
    public TreeNode toBST(int[] num, int left, int right){
    	if (left==right) {
			return new TreeNode(num[left]);
		}else if (right - left == 1) {
			TreeNode node = new TreeNode(num[right]);
			TreeNode node1 = new TreeNode(num[left]);
			node.left = node1;
			return node;
		}
    	int middle = (left + right) / 2;
    	TreeNode node = new TreeNode(num[middle]);
    	node.left = toBST(num, left, middle-1);
    	node.right = toBST(num, middle+1, right);
		return node;
    }
}
