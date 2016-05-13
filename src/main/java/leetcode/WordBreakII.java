package leetcode;

import java.util.*;

/**
 * Created by haodongl on 12/3/15.
 */
public class WordBreakII {

    Map<String, List<String>> wordBreakMap = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, Set<String> wordDict) {

        if(wordBreakMap.containsKey(s)) return wordBreakMap.get(s);

        List<String> result = new ArrayList<String>();

        if(s.length() == 0){
            if(wordDict.contains(s)){
                result.add(s);
            }
            return result;
        }

        for(int i=1; i <= s.length(); i++){
            String tmp = s.substring(0, i);

            if(wordDict.contains(tmp) && i!=s.length()){
                List<String> tmpL = wordBreak(s.substring(i), wordDict);
                if(tmpL.size() != 0){
                    for(String tmp2 : tmpL){
                        result.add(tmp + " " + tmp2);
                    }
                }
            }else if(wordDict.contains(tmp) && i==s.length()){
                result.add(s);
            }
        }

        wordBreakMap.put(s, result);

        return result;
    }

    public static void main(String[] args){
        String s = "catsanddogcatsand";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        System.out.println(new WordBreakII().wordBreak(s, dict));

    }

}
