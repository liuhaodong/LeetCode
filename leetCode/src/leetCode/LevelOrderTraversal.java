package leetCode;

import java.util.ArrayList;

public class LevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		traversal(root, 1, list);
		for (int i = list.size()-1; i >=0; i--) {
			result.add(list.get(i));
		}
		return result;
	}

	public void traversal(TreeNode root, int level,
			ArrayList<ArrayList<Integer>> list) {
		if (root == null) {
			return;
		}
		ArrayList<Integer> tmp = new ArrayList<>();
		if (level > list.size()) {
			list.add(tmp);
		}
		list.get(level-1).add(root.val);
		traversal(root.left, level+1, list);
		traversal(root.right, level+1, list);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		System.out.println(new LevelOrderTraversal().levelOrderBottom(node2));
	}

}
