package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haodongl on 12/9/15.
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.
 */


public class BinaryTreeMaximumPathSum {
    Map<TreeNode, Integer> maxPathMap = new HashMap<TreeNode, Integer>();

    public int maxPathSum(TreeNode root) {

        if(root == null){
            return Integer.MIN_VALUE;
        }else if(root.left == null && root.right == null){
            return root.val;
        }else {
            int leftPathSumMax;
            if(maxPathMap.containsKey(root.left)){
                leftPathSumMax = maxPathMap.get(root.left);
            }else {
                leftPathSumMax = getMaxPathSumFromRoot(root.left);
                maxPathMap.put(root.left, leftPathSumMax);
            }

            int rightPathSumMax;

            if(maxPathMap.containsKey(root.right)){
                rightPathSumMax = maxPathMap.get(root.right);
            }else {
                rightPathSumMax = getMaxPathSumFromRoot(root.right);
                maxPathMap.put(root.right, rightPathSumMax);
            }

            int pathThroughRoot = root.val + (leftPathSumMax>0?leftPathSumMax:0) + (rightPathSumMax>0?rightPathSumMax:0);

            int leftMax = maxPathSum(root.left);
            int rightMax = maxPathSum(root.right);
            if(leftMax > rightMax){
                return leftMax > pathThroughRoot ? leftMax : pathThroughRoot;
            }else {
                return rightMax > pathThroughRoot ? rightMax : pathThroughRoot;
            }
        }
    }

    public int getMaxPathSumFromRoot(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return root.val;
        }else {
            int leftPathSumMax;
            if(maxPathMap.containsKey(root.left)){
                leftPathSumMax = maxPathMap.get(root.left);
            }else {
                leftPathSumMax = getMaxPathSumFromRoot(root.left);
                maxPathMap.put(root.left, leftPathSumMax);
            }

            int rightPathSumMax;

            if(maxPathMap.containsKey(root.right)){
                rightPathSumMax = maxPathMap.get(root.right);
            }else {
                rightPathSumMax = getMaxPathSumFromRoot(root.right);
                maxPathMap.put(root.right, rightPathSumMax);
            }

            if(leftPathSumMax > rightPathSumMax){
                if (leftPathSumMax < 0)
                    return root.val;
                else
                    return root.val + leftPathSumMax;
            }else {
                if (rightPathSumMax < 0)
                    return root.val;
                else
                    return root.val + rightPathSumMax;
            }
         }
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(n1));
    }

}
