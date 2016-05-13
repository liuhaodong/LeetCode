package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haodongl on 12/10/15.
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();

        if(matrix.length ==0 || matrix[0].length ==0){
            return result;
        }


        int direction[] = {0,1,2,3};

        int up=0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int i=0,j=0, directionIndex = 0;

        while( up<=i && i<=bottom && left<=j && j<=right){
            result.add(matrix[i][j]);
            int currentDirection = direction[directionIndex];
            if(currentDirection == 0){
                if(j+1 > right){
                    directionIndex = (directionIndex + 1)%4;
                    up = i + 1;
                    i++;
                }else {
                    j++;
                }
            } else if(currentDirection == 1){
                if(i + 1>bottom){
                    directionIndex = (directionIndex + 1)%4;
                    right = j - 1;
                    j--;
                }else {
                    i++;
                }
            }else if(currentDirection == 2){
                if(j - 1 < left){
                    directionIndex = (directionIndex + 1)%4;
                    bottom = i - 1;
                    i--;
                }else {
                    j--;
                }
            }else {
                if(i - 1 < up){
                    directionIndex = (directionIndex + 1)%4;
                    left = j + 1;
                    j++;
                }else {
                    i--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = { {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16} };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

}
