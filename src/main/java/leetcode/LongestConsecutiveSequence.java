package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haodongl on 3/19/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        Map<Integer, Integer> startNumMap = new HashMap<>();
        Map<Integer, Integer> lengthMap = new HashMap<>();
        // Initialize the array
        for(int i=0; i<nums.length; i++){
            startNumMap.put(nums[i],nums[i]);
            lengthMap.put(nums[i], 1);
        }

        // then do a scan
        for(int num : nums){
            if(!startNumMap.containsKey(num)) continue;
            int currentLength = lengthMap.get(num);
            while(startNumMap.containsKey(num + currentLength)){
                lengthMap.put(num, currentLength + lengthMap.get(num + currentLength) );
                startNumMap.remove(num + currentLength);
                lengthMap.remove(num + currentLength);
                currentLength = lengthMap.get(num);
            }
        }
        int max = 1;
        for(int v : lengthMap.values() ){
            if(v > max) max = v;
        }
        return max;
    }

    public static void main(String[] args){
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        int[] array = {6,100, 4,5, 200, 1, 3, 2,7};
        System.out.println(test.longestConsecutive(array));
    }
}
