package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by haodongl on 4/15/16.
 */
public class PalindromePartition {
    Boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if(s == null || s.length() == 0) return result;
        isPalindrome = new Boolean[s.length()][s.length()];
        return pt(s, 0, s.length() - 1);
    }

    private List<List<String>> pt(String s, int start, int end){
        List<List<String>> result = new LinkedList<>();
        if(start > end) return result;
        for(int i= start; i<=end; i++){
            if(!checkPalindrome(s, start, i) ) continue;
            String tmp = s.substring(start, i+1);
            if(i==end){
                List<String> l = new LinkedList<>();
                l.add(tmp);
                result.add(l);
            }

            for(List<String> l : pt(s, i+1, end) ){
                l.add(0, tmp);
                result.add(l);
            }
        }
        return result;
    }

    private boolean checkPalindrome(String s, int start, int end){
        if(isPalindrome[start][end] != null) return isPalindrome[start][end];
        if(start == end){
            isPalindrome[start][end] = true;
            return true;
        } else if(start + 1 == end){
            isPalindrome[start][end] = (s.charAt(start) == s.charAt(end));
            return isPalindrome[start][end];
        } else{
            isPalindrome[start][end] = (s.charAt(start) == s.charAt(end)) && isPalindrome[start + 1][end-1];
            return isPalindrome[start][end];
        }
    }

    public static void main(String[] args){
        List<List<String>> result = new PalindromePartition().partition("");
        for(List<String> l : result){
            System.out.println(l);
        }
    }
}
