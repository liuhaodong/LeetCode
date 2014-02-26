package leetCode;


public class SameTree {

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
	
	TreeNode root_1 = new TreeNode(1);
	TreeNode left1_1 = new TreeNode(2);
	TreeNode right1_1 = new TreeNode(2);
	TreeNode left2_1 = new TreeNode(3);

	public  SameTree() {
		root.left = left1;
		root.right = right1;
		left1.left = left2;
		
		root_1.left = left1_1;
		root_1.right = right1_1;
		left1_1.left = left2_1;
	}

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
        	return true;
        }else if (p!=null&&q!=null) {
			boolean a = isSameTree(p.left, q.left);
			boolean b = isSameTree(p.right, q.right);
			if(a && b&&(p.val == q.val)) return true;
			else return false;
		}else return false;
    }
    
    public static void main(String args[]){
    	SameTree test = new SameTree();
    	System.out.println(test.isSameTree(test.root, test.root_1));
    }

}
