package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haodongl on 12/4/15.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if(s.length() == 0 || s == null || t.length() ==0 || t == null) return "";

        Map<Character, Integer> pCount = new HashMap<Character, Integer>();
        Map<Character, Integer> counterMap = new HashMap<Character, Integer>();

        for(int i =0; i< t.length(); i++){
            if(!pCount.containsKey(t.charAt(i))){
                pCount.put(t.charAt(i), 1);
            }else {
                pCount.put(t.charAt(i), pCount.get(t.charAt(i)) + 1);
            }
            counterMap.put(t.charAt(i), 0);
        }

        int start=0, end = 0;
        int windowSize = Integer.MAX_VALUE;
        String minWind = "";
        int foundCounter = 0;


        while (end < s.length()){
            char cur = s.charAt(end);
            if( pCount.containsKey(cur) ){
                if( counterMap.get(cur) < pCount.get(cur)){
                    counterMap.put(cur, counterMap.get(cur) + 1);
                    foundCounter++;
                }else {
                    counterMap.put(cur, counterMap.get(cur) + 1);
                }
            }

            if(foundCounter == t.length()){
                while (start <= end){
                    char left = s.charAt(start);
                    if(!pCount.containsKey(left)){
                        start++;
                    }else {
                        if(counterMap.get(left) > pCount.get(left)){
                            counterMap.put(left, counterMap.get(left)-1);
                            start++;
                        }else {
                            break;
                        }
                    }
                }

                if(windowSize > end - start + 1){
                    windowSize = end - start + 1;
                    minWind = s.substring(start, end + 1);
                }

            }
            end++;
        }

        return minWind;
    }

    public static void main(String[] args){
        System.out.println(new MinimumWindowSubstring().minWindow("ABCDCAD",""));
    }

}
