package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by haodongl on 12/9/15.
 */

//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//        For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//        Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")("));
    }

    public int longestValidParentheses(String s) {

        Deque<Character> stack = new ArrayDeque<Character>();

        int[] pLength = new int[s.length()];

        List<Integer> endIndex = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char tmpC = s.charAt(i);
            if (stack.isEmpty()) {
                stack.addLast(tmpC);
            } else {
                if (stack.peekLast() == tmpC || stack.peekLast() == ')' && tmpC == '(') {
                    stack.addLast(tmpC);
                } else {
                    stack.pollLast();
                    endIndex.add(i);
                }
            }
        }

        int max = 0;

        for (int index : endIndex) {
            pLength[index] = ((index - pLength[index - 1] - 2) >=0? pLength[index - pLength[index - 1] - 2]:0)  + 2 + (index-1>=0? pLength[index - 1]:0);

            if (pLength[index] > max) {
                max = pLength[index];
            }
        }

        return max;
    }
}
