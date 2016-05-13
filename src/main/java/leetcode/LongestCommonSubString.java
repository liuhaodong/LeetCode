package leetcode;

/**
 * Created by haodongl on 11/25/15.
 */
public class LongestCommonSubString {
    public String longestCommonStr(String s1, String s2){

        int maxLength = 0;
        int endIndex1 = 0;

        int [][] maxMatrix = new int[1000][1000];

        for(int i=0; i<= s1.length(); i++){
            int x = i;
            int y = 0;
            while (x<=s1.length() && y<=s2.length()){
                if(x==0 || y==0){ maxMatrix[x][y] = 0;}
                else if(s1.charAt(x -1 ) == s2.charAt(y -1)){
                    maxMatrix[x][y] = maxMatrix[x-1][y-1] + 1;
                }else {
                    maxMatrix[x][y] = 0;
                }

                if(maxMatrix[x][y] > maxLength){
                    maxLength = maxMatrix[x][y];
                    endIndex1 = x;
                }
                x++;
                y++;
            }
        }

        for(int j=1; j<=s2.length(); j++){
            int x = 0;
            int y = j;
            while (x<=s1.length() && y<=s2.length()){
                if(x==0 || y==0){ maxMatrix[x][y] = 0;}
                else if(s1.charAt(x - 1) == s2.charAt(y -1)){
                    maxMatrix[x][y] = maxMatrix[x-1][y-1] + 1;
                }else {
                    maxMatrix[x][y] = 0;
                }

                if(maxMatrix[x][y] > maxLength){
                    maxLength = maxMatrix[x][y];
                    endIndex1 = x;
                }
                x++;
                y++;
            }
        }

        if(maxLength ==0){
            return "";
        }else {
            return s1.substring(endIndex1 - maxLength, endIndex1);
        }
    }
}
