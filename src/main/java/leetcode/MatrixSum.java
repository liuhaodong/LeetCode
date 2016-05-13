package leetcode;

/**
 * Created by haodongl on 4/13/16.
 */
public class MatrixSum {
    int[][] preSum;

    public void NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        preSum = new int[matrix.length][matrix[0].length];

        preSum[0][0] = matrix[0][0];
        for(int i=1; i<matrix[0].length;i++){
            preSum[0][i] = preSum[0][i-1] + matrix[0][i];
        }

        for(int i=1; i<matrix.length; i++){
            preSum[i][0] = preSum[i-1][0] + matrix[i][0];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                preSum[i][j] =matrix[i][j]+ preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(preSum == null) return 0;
        if(row1 > row2 || col1 > col2){
            return 0;
        }
        if(row1 == 0 && col1 == 0) return preSum[row2][col2];
        return preSum[row2][col2] - sumRegion(0,0,row2, col1 -1) - sumRegion(0,0, row1 -1, col2) + sumRegion(0,0, row1 -1, col1 -1);
    }

    public static void main(String[] args){
        MatrixSum test = new MatrixSum();
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        test.NumMatrix(matrix);
        System.out.println(test.sumRegion(0, 0, 0, 0));
    }
}
