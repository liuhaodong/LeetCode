package leetCode;

public class MaxSubarray {
	public int maxSubArray(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int[] sumFront = new int[100000];
		sumFront[0] = 0;
		boolean allNeg = true;
		for (int i = 1; i < A.length + 1; i++) {
			sumFront[i] += A[i - 1] + sumFront[i - 1];
			//System.out.println(sumFront[i]);
			if (sumFront[i] > 0) {
				allNeg = false;
			}
		}
		if (allNeg == false) {
			int sum = 0;
			int max = A[0];
			int min = 0;
			int right = 0;
			int left = 0;
			for (int i = 1; i < A.length + 1; i++) {
				if (sumFront[i] >= max) {
					max = sumFront[i];
					right = i;
				}
			}
			for (int i = 0; i <=right; i++) {
				if (sumFront[i] < min) {
					min = sumFront[i];
					left = i;
				}
			}
			sum = max - min;
			return sum;
		} else {
			int sum = A[0];
			for (int i = 1; i < A.length+1; i++) {
				for (int j = 0; j < i; j++) {
					if (sumFront[i] - sumFront[j] > sum) {
						sum = sumFront[i] - sumFront[j];
					}
				}
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		int[] A = { -2, -2 };
		System.out.println(new MaxSubarray().maxSubArray(A));
	}
}
