package leetcode;

/**
 * Created by haodongl on 4/26/16.
 * // For example,
 // Given:
 // s1 = "aabcc",
 // s2 = "dbbca",

 // When s3 = "aadbbcbcac", return true.
 // When s3 = "aadbbbaccc", return false.
 */
public class Interleaving {
    boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
        dp = new boolean[s1.length() + 1][s2.length() +1];
        dp[0][0] = true;
        for(int i=1; i <= s2.length(); i++){
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for(int i=1; i<=s1.length(); i++){
            dp[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s3.charAt(i+j-1) == s1.charAt(i-1)){
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if(s3.charAt(i+j-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        System.out.println(new Interleaving().isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
