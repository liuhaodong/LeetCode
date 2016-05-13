package leetcode;

/**
 * Created by haodongl on 11/24/15.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {

        if(s.length() <=1) return s;

        int length = s.length();

        for(int i = length/2; i>=0; i--){
            String left = s.substring(0, i);
            String right = s.substring(i , s.length());
            int tmp = canFormPalindrome(left,right);
            if( tmp == 0){
                String tmp2 = reverseString(right.substring(1));
                return tmp2+right;
            }else if(tmp == 2){
                String tmp2 = reverseString(right);
                return tmp2 + right;
            }

        }

        return null;
    }

    public int canFormPalindrome(String left, String right){
        if(left.length() == 0){
            return 0;
        }

        boolean flag = true;

        if(right.length() > left.length()){
            for(int i=0; i< left.length(); i++){
                if(left.charAt(left.length() - i -1) != right.charAt(i+1))
                    flag = false;
            }
        }else {
            flag = false;
        }


        for(int i=0; i< left.length(); i++){
            if(left.charAt(left.length() - i -1) != right.charAt(i) && flag == false)
                return 1;
        }

        if(flag) return 0;

        return 2;
    }

    public String reverseString(String s){
        String result = "";

        for(int i=s.length()-1; i>=0; i--){
            result = result + s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
    }

}
