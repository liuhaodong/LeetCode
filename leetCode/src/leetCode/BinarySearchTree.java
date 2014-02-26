package leetCode;

public class BinarySearchTree {
	public int numTrees(int n) {
		int num[] = new int[1000];
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;
		num[3] = 5;
		for (int i = 4; i <= n; i++) {
			int temp = 0;
			for (int j = 0; j <i; j++) {
				temp += num[j]*num[i-1-j];
			}
			num[i] = temp;
		}
		return num[n];
	}
	
	public static void main(String args[]){
		System.out.println(new BinarySearchTree().numTrees(5));
	}
	
}
