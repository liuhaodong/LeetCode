package leetcode;

import java.util.Arrays;

/**
 * Created by haodongl on 3/21/16.
 */
public class EditDistance {
    int[][] minDistance;
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.length() == 0 || word2.length()==0 ) return word1.length()> word2.length() ? word1.length() : word2.length();
        if(minDistance == null){
            minDistance = new int[word1.length()+1][word2.length()+1];
            for(int i=0; i<minDistance.length; i++){
                Arrays.fill(minDistance[i], Integer.MAX_VALUE);
            }
        }
        return findMin(word1.length(), word2.length(),word1, word2 );
    }

    private int findMin(int i, int j, String word1, String word2){
        if(minDistance[i][j] != Integer.MAX_VALUE){
            return minDistance[i][j];
        }

        if(i == 0 || j == 0){
            minDistance[i][j] = i > j? i:j;
            return minDistance[i][j];
        }
        int d1 = findMin(i-1, j, word1, word2) + 1;
        int d2 = findMin(i, j-1, word1, word2) + 1;
        int d3;
        if(word1.charAt(i-1) == word2.charAt(j-1) ){
            d3 = findMin(i-1,j-1, word1, word2);
        }else{
            d3 = findMin(i-1,j-1, word1, word2) + 1;
        }
        int minD = d1 < d2? d1:d2;
        minD = d3 < minD? d3:minD;
        minDistance[i][j] = minD;
        return minD;
    }

    public static void main(String[] args){
        System.out.println(new EditDistance().minDistance(null,"abc"));
    }
}
