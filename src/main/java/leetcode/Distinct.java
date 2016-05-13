package leetcode;

/**
 * Created by haodongl on 4/27/16.
 */
public class Distinct {
    int dp[][];
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        dp = new int[s.length() + 1][t.length() +1];

        for(int i=0; i<s.length()+1; i++){
            for(int j=0; j<t.length() + 1; j++){
                dp[i][j] = -1;
            }
        }
    return numDistinct(s, s.length(), t, t.length());
    }

    private int numDistinct(String s, int i, String t, int j){
        if(dp[i][j] != -1) return dp[i][j];

        if(i < j) {
            dp[i][j] = 0;
            return 0;
        }

        if(j==0){
            dp[i][j] = 1;
            return 1;
        }

        int result = 0;
        if(s.charAt(i-1) == t.charAt(j-1)){
            result = numDistinct(s, i-1, t, j-1);
        }

        // find index which s.charAt(index) == t.charAt(j)
        int index = i-2;
        while(index >= 0){
            if(s.charAt(index) == t.charAt(j-1)) break;
            index--;
        }
        if(index != -1){
            result += numDistinct(s, index+1, t, j);
        }

        dp[i][j] = result;
        return result;
    }
    public static void main(String[] args){
        System.out.println(new Distinct().numDistinct("aaabb","aab"));
    }
}
