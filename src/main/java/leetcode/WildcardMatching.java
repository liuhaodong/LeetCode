package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haodongl on 12/16/15.
 *
 "aabbbabaaaaaabbabbaabbabbbabaabaaabbbabbabbbbababbabaaaaaabaabaabbbababaaabbaabaaabaabaabaaabaaababbaabababbabbababbbbabbababbbababaaaabaabbbabababaabbbaaababbbbbbbbabaaabbaabbbaababaaaababababbabbbbbb"
 "a*bab***b**abbabaa**a*a**b****b*b*****b*bb***a**a**a***baba*abbbaa***bb**bbabb*b*b*bab*a****a*bb*a**b" * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

    public static void main(String[] args){
        System.out.println(new WildcardMatching().isMatch("aabbbabaaaaaabbabbaabbabbbabaabaaabbbabbabbbbababbabaaaaaabaabaabbbababaaabbaabaaabaabaabaaabaaababbaabababbabbababbbbabbababbbababaaaabaabbbabababaabbbaaababbbbbbbbabaaabbaabbbaababaaaababababbabbbbbb","a*bab***b**abbabaa**a*a**b****b*b*****b*bb***a**a**a***baba*abbbaa***bb**bbabb*b*b*bab*a****a*bb*a**b"));
    }


    class StringPair{
        String s;
        String p;

        public StringPair(String s, String p){
            this.s = s;
            this.p = p;
        }

        @Override
        public int hashCode(){
            return s.hashCode() + p.hashCode();
        }

        @Override
        public boolean equals(Object o){
            if(o instanceof StringPair){

                StringPair cmp = (StringPair)o;

                return cmp.s.equals(this.s) && cmp.p.equals(this.p);

            }else {
                return false;
            }
        }
    }

    Map<StringPair, Boolean> isMatchMap = new HashMap<StringPair, Boolean>();

    boolean isProcessed = false;

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        } else if (s.length() > 0 && p.length() > 0 && p.charAt(p.length() - 1) != '?' && p.charAt(p.length() - 1) != '*' && p.charAt(p.length() - 1) != s.charAt(s.length() - 1)) {
            return false;
        }

        if(!isProcessed){
            StringBuilder sb = new StringBuilder();

            boolean isLastStar = false;
            for(int i=0; i< p.length(); i++){
                if(p.charAt(i) == '*' && !isLastStar){
                    sb.append(p.charAt(i));
                    isLastStar = true;
                }else {
                    isLastStar = false;
                    sb.append(p.charAt(i));
                }
            }

            isProcessed = true;

            return isMatch(s, sb.toString());
        }


        StringPair tmp = new StringPair(s, p);

        if(isMatchMap.containsKey(tmp)){
            return isMatchMap.get(tmp);
        }

        int pCounter = 0;

        for(int i=0; i< p.length(); i++){
            if(p.charAt(i) != '*')
                pCounter++;
        }

        if(pCounter > s.length()){
            return false;
        }

        if(s.length() == 0 && p.length() == 0){
            return true;
        }else if(s.length() != 0 && p.length() == 0){
            return false;
        }else if(s.length() == 0 && p.length() !=0){
            if( p.charAt(0) != '*'){
                return false;
            }else {
                boolean result = isMatch(s, p.substring(1));

                isMatchMap.put(tmp, result);

                return result;
            }
        }

        char sFront = s.charAt(0);
        char pFront = p.charAt(0);

        if(sFront == pFront || pFront == '?' ){
            boolean result = isMatch(s.substring(1), p.substring(1));
            isMatchMap.put(tmp, result);
            return result;
        }else if(pFront == '*'){
            boolean result =  isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
            isMatchMap.put(tmp, result);
            return result;
        }else {
            isMatchMap.put(tmp, false);
            return false;
        }
    }

}
