package leetcode;


public class ReverseBits {
	public int reverseBits(int n) {
		int testBit = 1;
		int reverse = 0;
		int shift = 1<<32;
		for(int i=0; i< 32 ; i++){
			if((testBit&n) == 0){
			}else {
				reverse += 1<<(31 - i);
			}
			testBit =  testBit << 1;
			shift = shift >>1 ;
		}
		return reverse;
	}
	
	public static void main(String[] args){
		System.out.println(new ReverseBits().reverseBits(43261596));
	}
}
