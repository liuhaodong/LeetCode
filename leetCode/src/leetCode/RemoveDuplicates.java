package leetCode;

public class RemoveDuplicates {
	// The main idea is to keep track of the amount of distinct numbers in
	// array. Then we add new numbers to the array when finding new number and
	// increase the amount.
	public int removeDuplicates(int[] A) {
		if (A.length < 2) {
			return A.length;
		}
		int i = 1;
		int j = 1;
		while (j < A.length) {
			if (A[j] > A[i - 1]) {
				A[i] = A[j];
				i++;
			} else {
				j++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 1, 1, 2, 2, 3 };
		int m = new RemoveDuplicates().removeDuplicates(A);
		for (int i = 0; i < m; i++) {
			System.out.println(A[i]);
		}
	}
}
