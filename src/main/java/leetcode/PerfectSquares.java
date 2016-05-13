package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by haodongl on 2/25/16.
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


 */
public class PerfectSquares {
    public int numSquares(int n) {
        if(n ==0) return 0;
        int level = 0;
        List<Integer> remainQueue = new ArrayList<Integer>();
        remainQueue.add(n);

        Set<Integer> searched = new HashSet<Integer>();
        while (!remainQueue.isEmpty()){
            List<Integer> tmpRemain = new ArrayList<Integer>();
            for(int i=0; i< remainQueue.size(); i++){
                int currentRemain = remainQueue.get(i);
                if(currentRemain == 0){
                    return level;
                }else if(!searched.contains(currentRemain)){
                    // put the remain possible values to new queue
                    int maxPossible = (int) Math.sqrt(remainQueue.get(i));
                    for(int j=maxPossible; j>0; j--){
                        tmpRemain.add(currentRemain - j*j);
                        searched.add(currentRemain);
                    }
                }
            }
            level++;
            remainQueue = tmpRemain;
        }
        char[][] grid = new char[2][];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return level;
    }

    private void test(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
    }

    public static void main(String[] args){
        System.out.println(Integer.valueOf('1' + ""));
    }
}
