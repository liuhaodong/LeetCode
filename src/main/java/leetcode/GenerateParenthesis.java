package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haodongl on 4/15/16.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) return result;
        generate(n, 0,0,"",result);
        return result;
    }

    private void generate(int n, int leftCount, int rightCount, String path, List<String> result){
        if(leftCount == n && rightCount == n){
            result.add(path);
        }else if(leftCount >= rightCount && leftCount <= n){
            generate(n, leftCount + 1, rightCount, path + "(", result);
            generate(n, leftCount, rightCount+1, path + ")", result);
        }
    }

    public static void main(String[] args){
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
