package leetcode;

import java.util.Arrays;

/**
 * Created by haodongl on 3/22/16.
 */
public class PalindromPartition {
    int[][] min;
    int[][] isPalin;
    public int minCut(String s) {
        if(s==null || s.length() == 0 ) return 0;
        if(min == null){
            min = new int[s.length()][s.length()];
            isPalin = new int[s.length()][s.length()];
        }
        for(int i=0; i<min.length; i++){
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(isPalin[i], Integer.MAX_VALUE);
        }
        return minCut(s, 0, s.length()-1);
    }

    private int minCut(String s, int i, int j){
        if(min[i][j] != Integer.MAX_VALUE){
            return min[i][j];
        }

        if(isPalindrom(s,i,j)){
            min[i][j] = 0;
            return 0;
        }

        int minC = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            if(!isPalindrom(s,i,k)) continue;
            int min2 = minCut(s, k+1, j);
            if( min2 + 1 < minC){
                minC =  min2+1;
            }
        }
        min[i][j] = minC;
        return minC;
    }

    private boolean isPalindrom(String s, int i, int j){
        if(isPalin[i][j] != Integer.MAX_VALUE){
            return isPalin[i][j] == 1;
        }
        int end = j;
        int start = i;
        if( s.charAt(start) == s.charAt(end)){
            if(start == end || end==start+1) return true;
            boolean b =  isPalindrom(s, start+1, end-1);
            isPalin[i][j] = b?1:0;
            return b;
        }
        isPalin[i][j] = 0;
        return false;
    }

    public static void main(String[] args){
        PalindromPartition test = new PalindromPartition();
        System.out.println(test.minCut(""));
    }
}
