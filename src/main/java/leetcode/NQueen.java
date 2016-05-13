package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haodongl on 3/5/16.
 */
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n ==0 || n == 2) return result;
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        // find the solution
        List<Integer> current = new ArrayList<>();
        solve(n, current, 0, solution);

        // construct result with found solution
        for(List<Integer> list : solution){
            List<String> sol = new ArrayList<>();
            for(int p : list){
                sol.add(createStr(n, p));
            }
            result.add(sol);
        }
        return result;
    }

    private String createStr(int n, int pos){
        char[] tmp = new char[n];
        Arrays.fill(tmp, '.');
        tmp[pos] = 'Q';
        return new String(tmp);
    }

    private void solve(int n, List<Integer> current, int level, List<List<Integer>> result){
        // if it's last row
        if(level == n -1){
            for(int i=0; i<n; i++){
                // check every column
                if(check(current, i, n)){
                    // valid position, add to result
                    List<Integer> valid = new ArrayList<>(current);
                    valid.add(i);
                    result.add(valid);
                }
            }
        }else {
            // not last row
            for(int i=0; i<n; i++){
                // check every column
                if(check(current, i, n)){
                    // is a valid position, then go on with search
                    List<Integer> valid = new ArrayList<>(current);
                    valid.add(i);
                    solve(n, valid, level + 1, result);
                }
            }
        }
    }

    private boolean check(List<Integer> current, int position, int n){
        // if it's first row, then whatever position
        if(current.size() == 0) return true;

        // check row
        for(int pos : current){
            if(pos == position) return false;
        }

        // check diag
        int currentLevel = current.size();
        for(int i=1; i <= currentLevel; i++){
            int level = currentLevel - i;
            int pos = current.get(level);
            if(pos == position - i || pos == position + i) return false;
        }
        return true;
    }

    public static void main(String[] args){
        NQueen test = new NQueen();
        List<List<String>> result = test.solveNQueens(4);
        for(List<String> l : result){
            System.out.println(l);
        }
    }
}
