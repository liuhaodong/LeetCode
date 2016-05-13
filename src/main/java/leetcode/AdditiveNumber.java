package leetcode;

/**
 * Created by haodongl on 11/30/15.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {

        if(num.length() < 3) return false;

        for(int initLengthA = 1; initLengthA <= num.length()/2; initLengthA++){
            for(int initLengthB = 1; initLengthB + initLengthA < num.length() && initLengthB <=num.length()/2; initLengthB ++){
                if(isAdditiveNumber(num, initLengthA, initLengthB)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isAdditiveNumber(String num, int lengthA, int lengthB){
        if(lengthA + lengthA >= num.length()) return false;
        String a = num.substring(0, lengthA);
        String b = num.substring(lengthA, lengthA + lengthB);

        if(a.charAt(0) == '0' && a.length() > 1 || b.charAt(0) == '0' && b.length() >1) return false;

        long numA = Long.parseLong(a);
        long numB = Long.parseLong(b);

        long numC = numA + numB;
        String c = String.valueOf(numC);

        if(lengthA + lengthB + c.length() > num.length()) return false;

        if(c.equals(num.substring(lengthA + lengthB,lengthA + lengthB+ c.length())) && c.charAt(0) != '0'){
            if(c.length() + lengthA + lengthB == num.length()){
                return true;
            }else {
                return isAdditiveNumber(num.substring(lengthA), lengthB, c.length());
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        AdditiveNumber test = new AdditiveNumber();
        System.out.println(test.isAdditiveNumber("211738", 2,2));
    }

}
