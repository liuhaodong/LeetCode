package leetcode;

import java.util.*;

/**
 * Created by haodongl on 4/13/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return 0;
        Map<String, Integer> distance = new HashMap<>();
        Set<String> allWords = new HashSet<>(wordList);
        allWords.add(beginWord);
        allWords.add(endWord);
        for(String word : allWords){
            distance.put(word, Integer.MAX_VALUE);
        }
        List<String> queue = new ArrayList<>();
        queue.add(beginWord);
        distance.put(beginWord, 1);
        while(!queue.isEmpty()){
            List<String> nextQueue = new ArrayList<>();
            for(String word : queue){
                for(String next : getNeighbours(word, allWords, distance)){
                    distance.put(next, distance.get(word) + 1);
                    nextQueue.add(next);
                    if(next.equals(endWord)) return distance.get(next);
                }
            }
            queue = nextQueue;
        }
        return 0;
    }

    List<String> getNeighbours(String word, Set<String> wordList, Map<String, Integer> distance){
        List<String> result= new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            StringBuilder sb = new StringBuilder(word);
            for(int c = 'a'; c<='z' ; c++){
                if(c==word.charAt(i)) continue;
                sb.setCharAt(i,(char)c);
                String tmp = sb.toString();
                if(wordList.contains(tmp) && distance.get(tmp) == Integer.MAX_VALUE) result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Set<String> test = new HashSet<>();
        test.add("hot");
        test.add("dog");
        System.out.println(new WordLadder().ladderLength("hot", "dog", test));
    }
}
