package leetcode;

/**
 * Created by haodongl on 4/15/16.
 */
public class Pow {
    public double myPow(double x, int n) {
        double result = 1;
        int mask = 0x0001;
        double m = x;
        if(n == Integer.MIN_VALUE){
            return 1/ (myPow(x, Integer.MAX_VALUE) * x);
        }
        int tmp = (n > 0) ? n : -n;
        for(int i=0; i<32; i++){
            int test = mask & tmp;
            if(test != 0){
                result *= m;
            }
            m = m*m;
            mask = mask<<1;
        }
        if(n < 0) result = 1/result;
        return result;
    }

    public static void main(String[] args){
        System.out.println(new Pow().myPow(8.8,-3));
    }
}
