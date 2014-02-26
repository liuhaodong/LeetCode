package leetCode;

import java.util.ArrayList;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
    	if (m==0&&n==0) {
			return;
		}
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<m && j < n){
        	if (A[i]< B[j]) {
				list.add(A[i]);
				i++;
			}else {
				list.add(B[j]);
				j++;
			}
        }
        if (i==m) {
			for (int k = j; k < n; k++) {
				list.add(B[k]);
			}
		}else {
			for (int k = i; k < m; k++) {
				list.add(A[k]);
			}
		}
        int k = 0;
        for (Integer integer : list) {
			A[k] = integer;
			k++;
		}
    }
    
    public static void main(String[] args){
    	int [] A = {1,2,4,0,0};
    	int [] B = {3,5};
    	new MergeSortedArray().merge(A, 0, B, 0);
    	for (int i = 0; i < 5; i++) {
			System.out.println(A[i]);
		}
    }
}
