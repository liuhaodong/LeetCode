package leetcode;

import java.util.Arrays;

/**
 * Created by haodongl on 4/27/16.
 */
public class ReconstructBST {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, int start1, int[] inorder, int start2, int length){
        if(length == 0) return null;
        if(length == 1) return new TreeNode(preorder[start1]);
        // find root, which is first in preorder
        TreeNode root = new TreeNode(preorder[start1]);

        // find root index in inorder array
        int rootIndex = Arrays.binarySearch(inorder, root.val);
        int leftSize = (rootIndex - start2);
        int rightSize = length - leftSize - 1;

        // construct left
        TreeNode left = buildTree(preorder, start1 + 1, inorder, start2, leftSize);

        // construct right
        TreeNode right = buildTree(preorder, start1+1+leftSize, inorder, rootIndex+1, rightSize);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args){
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        new ReconstructBST().buildTree(preorder, inorder);
    }
}
