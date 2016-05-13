package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by haodongl on 4/5/16.
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int maxSoFar = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > 0){
                max[i] = nums[i] * max[i-1] > nums[i] ? nums[i] * max[i-1] : nums[i];
                min[i] = nums[i] * min[i-1] < nums[i] ? nums[i] * min[i-1] : nums[i];
            } else if(nums[i] < 0){
                max[i] = nums[i] * min[i-1] > nums[i] ? nums[i] * min[i-1] : nums[i];
                min[i] = nums[i] * max[i-1] < nums[i] ? nums[i] * max[i-1] : nums[i];
            } else{
                max[i] = 0;
                min[i] = 0;
            }
            if(maxSoFar < max[i]){
                maxSoFar = max[i];
            }
        }

        Deque<Integer> test = new ArrayDeque<>();
        test.peekFirst();
        return maxSoFar;
    }

    public static void main(String[] args){
        int[] test = {2,0,3,-2,4, -5,0,-6,0};
        MaxProduct m = new MaxProduct();
        System.out.print(m.maxProduct(test));
    }
}
