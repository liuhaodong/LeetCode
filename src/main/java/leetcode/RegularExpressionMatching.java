package leetcode;

/**
 * Created by haodongl on 12/16/15.
 * <p>
 * "aaaaaaaaaaaaab"
 * "a*a*a*a*a*a*a*a*a*a*c"
 * <p>
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
    }

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        else if ( s.length() > 0 && p.length() > 0 && p.charAt(p.length() - 1) != '.' && p.charAt(p.length() - 1) != '*' && p.charAt(p.length() - 1) != s.charAt(s.length() - 1)) {
            return false;
        }

        if (s.length() == 0 && p.length() == 0) {
            return true;
        }  else if (s.length() == 0 && p.length() != 0) {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            } else {
                return false;
            }
        } else if (s.length() != 0 && p.length() == 0) {
            return false;
        }

        String sFront = s.substring(0, 1);
        String pFront = getNextP(p);

        if (pFront.length() == 1) {
            if (sFront.equals(pFront) || pFront.equals(".")) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            if (pFront.charAt(0) == sFront.charAt(0) || pFront.charAt(0) == '.') {
                return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(2)) || isMatch(s, p.substring(2));
            } else
                return isMatch(s, p.substring(2));
        }

    }

    private String getNextP(String p) {
        if (p.length() == 0) {
            return p;
        } else if (p.length() == 1) {
            return p;
        } else if (p.charAt(1) == '*') {
            return p.substring(0, 2);
        } else {
            return p.substring(0, 1);
        }
    }

}
