package leetCode;

public class SingleNumber {
	public int singleNumber(int a[]) {
		int result = a[0];
		for (int i = 1; i < a.length; i++) {
			result = result ^ a[i];
		}
		return result;
	}
	
	public static void main(String args[]){
		int a[] = {1,1,2,2,3};
		System.out.println(new SingleNumber().singleNumber(a));
	}

}
