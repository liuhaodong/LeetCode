package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haodongl on 12/2/15.
 */
public class GreyCode {
    public List<Integer> grayCode(int n) {

        List<List<String>> sequence = new ArrayList<List<String>>();

        sequence.add(new ArrayList<String>());
        List<String> one = new ArrayList<String>();
        one.add("0");
        one.add("1");
        sequence.add(one);


        for(int i=2; i<=n; i++){
            List<String> prev = sequence.get(i-1);
            List<String> cur = new ArrayList<String>();
            for(String c : prev){
                cur.add('0' + c);
            }
            for(int j = 0; j< prev.size(); j++){
                cur.add('1'+ prev.get(prev.size() - j -1));
            }
            sequence.add(cur);
        }

        List<String> resultList = sequence.get(n);

        List<Integer> result = new ArrayList<Integer>();

        for(String s : resultList){
            int tmp = 0;
            for(int i=0; i<s.length(); i++){
                tmp += Character.getNumericValue(s.charAt(i)) * (1<<(s.length() - i -1));
            }
            result.add(tmp);
        }

        if(n==0){
            result.add(0);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new GreyCode().grayCode(0));
    }

}
