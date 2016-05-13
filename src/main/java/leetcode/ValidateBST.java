package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haodongl on 2/24/16.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 [-2147483648,null,2147483647]
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        List<TreeNode> list = preorder(root);
        long current = Long.MIN_VALUE;
        for(TreeNode n : list){
            if(n.val <= current){
                return false;
            }
            current = n.val;
        }
        return true;
    }

    private List<TreeNode> preorder(TreeNode root){
        List<TreeNode> result = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }
        if(root.left == null && root.right == null){
            result.add(root);
            return result;
        }
        if(root.left != null && root.right !=null){
            result.addAll(preorder(root.left));
            result.add(root);
            result.addAll(preorder(root.right));
            return result;
        }
        if(root.left == null){
            result.add(root);
            result.addAll(preorder(root.right));
        } else{
            result.addAll(preorder(root.left));
            result.add(root);
            return result;
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(-2147483648);
        TreeNode n2 = null;
        TreeNode n3 = new TreeNode(2147483647);
        n1.left = n2;
        n1.right = n3;
        System.out.println(new ValidateBST().isValidBST(n1));
    }
}
