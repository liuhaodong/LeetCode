package leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int mod = x%10;
        while(x !=0){
        	result = result*10 + mod;
        	x = x/10;
        	mod = x%10;
        }
        return result;
    }
    
    public static void main(String args[]){
    	System.out.println(new ReverseInteger().reverse(10000));
    }
}
