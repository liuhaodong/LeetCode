package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haodongl on 3/5/16.
 */
public class PhoneNumberCombine {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[][] map = {{},{}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w', 'x', 'y','z'} };
        return null;
    }

    private void dfsUtil(){
    }

    private String createStr(int n, int pos){
        char[] tmp = new char[n];
        Arrays.fill(tmp, '.');
        tmp[pos] = 'Q';
        return new String(tmp);
    }
}
