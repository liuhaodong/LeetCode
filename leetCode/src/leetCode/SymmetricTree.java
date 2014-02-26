package leetCode;

import java.util.ArrayList;
import java.util.Stack;

import javax.xml.soap.Node;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if (root==null) {
			return true;
		}else {
			return isSym(root.left, root.right);
		}
    }
    
    public boolean isSym(TreeNode left, TreeNode right){
    	if (left==null) {
			return right==null;
		}
    	if (right==null) {
			return left == null;
		}
    	if (left.val != right.val) {
			return false;
		}else {
			if (!isSym(left.left, right.right)) {
				return false;
			}
			if (!isSym(left.right, right.left)) {
				return false;
			}
		}
    	return true;
    }
    
}
