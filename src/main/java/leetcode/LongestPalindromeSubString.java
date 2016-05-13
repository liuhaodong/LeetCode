package leetcode;

/**
 * Created by haodongl on 11/25/15.
 */
public class LongestPalindromeSubString {
    public String longestPalindrome(String s) {
        int maxLength = 1;
        int startIndex = 0;
        int endIndex = 0;

        boolean[][] isPalindrome = new boolean[1000][1000];

        char[] str = s.toCharArray();

        for(int i=0; i<str.length; i++){
            isPalindrome[i][i] = true;
            if(i+1 <= str.length - 1 &&str[i] == str[i+1] ){
                isPalindrome[i][i+1] = true;
                maxLength = 2;
                startIndex = i;
                endIndex = i+1;
            }else {
                isPalindrome[i][i+1] = false;
            }
        }

        for(int i=0; i<str.length; i++){
            int x = i;
            int y = i;
            while(x>=0 && y <str.length){
                if(x - 1 >=0 && y + 1 < str.length){
                    isPalindrome[x-1][y+1] = isPalindrome[x][y] && str[x -1] == str[y+1];

                    if(isPalindrome[x-1][y+1] && (y-x+3) > maxLength){
                        maxLength = y -x +3;
                        startIndex = x -1;
                        endIndex = y+1;
                    }
                }
                x--;
                y++;
            }
        }

        for(int i=0; i<str.length - 1; i++){
            int x = i;
            int y = i+1;
            while(x>=0 && y <str.length){
                if(x - 1 >=0 && y + 1 < str.length){
                    isPalindrome[x-1][y+1] = isPalindrome[x][y] && str[x -1] == str[y+1];

                    if(isPalindrome[x-1][y+1] && (y-x+3) > maxLength){
                        maxLength = y -x +3;
                        startIndex = x - 1;
                        endIndex = y+1;
                    }
                }
                x--;
                y++;
            }
        }



        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        LongestPalindromeSubString test = new LongestPalindromeSubString();
        System.out.println(test.longestPalindrome("a"));
    }
}
