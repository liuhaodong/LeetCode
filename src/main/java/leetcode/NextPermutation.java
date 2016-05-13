package leetcode;

import java.util.Arrays;

/**
 * Created by haodongl on 4/19/16.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int startIndex = nums.length - 1;
        int currentValue = Integer.MIN_VALUE;
        while(startIndex >= 0){
            if(nums[startIndex] < currentValue) break;
            else {
                currentValue = nums[startIndex];
                startIndex--;
            }
        }
        if(startIndex < 0) Arrays.sort(nums);
        else {
            int swapIndex = nums.length - 1;
            while(swapIndex >= startIndex){
                if(nums[swapIndex] > nums[startIndex]) break;
                else swapIndex--;
            }

            int tmp = nums[swapIndex];
            nums[swapIndex] = nums[startIndex];
            nums[startIndex] = tmp;
            Arrays.sort(nums, startIndex + 1, nums.length);
        }
    }

    public static void main(String[] args){
        int[] test = {1};
        new NextPermutation().nextPermutation(test);
        for(int n : test){
            System.out.println(n);
        }
    }
}
