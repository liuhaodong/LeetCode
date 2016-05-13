package leetcode;

/**
 * Created by haodongl on 4/27/16.
 */
public class FixBST {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode first = null, second = null;
        findSwap(root, first, second);
    }

    private void findSwap(TreeNode root, TreeNode first, TreeNode second){
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode current = root;
        while(current!=null){
            if(current.val < prev.val){
                if(first == null){
                    first = prev;
                    second = current;
                }else{
                    second = current;
                }
            }
            if(current.left == null){
                prev = current;
                current = current.right;
            }else{
                TreeNode tmp = current.left;
                while(tmp.right != null && tmp.right != current){
                    tmp = tmp.right;
                }
                if(tmp.right == null){
                    tmp.right = current;
                    current = current.left;
                }else{
                    prev = current;
                    tmp.right = null;
                    current = current.right;
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        new FixBST().recoverTree(n1);
    }
}
