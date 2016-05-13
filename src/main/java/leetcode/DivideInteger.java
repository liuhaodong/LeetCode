package leetcode;

/**
 * Created by haodongl on 4/19/16.
 */
public class DivideInteger {
    public long divide(long dividend, long divisor){
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend < divisor && dividend > 0) return 0;
        else if(dividend == divisor) return 1;
        else if(divisor == 1) return dividend;
        else if(dividend < 0 && divisor < 0){
            return divide(-dividend, -divisor);
        }
        else if(dividend < 0){
            return 0 - divide(-dividend, divisor);
        }else if(divisor < 0){
            return -divide(dividend, -divisor);
        }
        else {
            int count =1;
            long cur = divisor;
            while(cur + cur <= dividend){
                cur += cur;
                count += count;
            }
            long left = dividend - cur;
            return count + divide(left, divisor);
        }
    }

    public int divide(int dividend, int divisor) {
        long result = divide( (long) dividend, (long) divisor );
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int) result;
    }

    public static void main(String[] args){
        System.out.println(new DivideInteger().divide(1,2));
    }
}
