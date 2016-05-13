package leetcode;

/**
 * Created by haodongl on 12/16/15.
 *
 * [1,10000000]
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {

        if(nums == null || nums.length <2){
            return 0;
        }

        int maxNum = Integer.MIN_VALUE;

        for(int i : nums){
            if(maxNum < i) maxNum = i;
        }

        boolean[] hasNumArray = new boolean[maxNum + 1];

        int max = 0;

        for(int i=0; i<nums.length; i++){
            hasNumArray[nums[i]] = true;
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int lastIndex = Integer.MIN_VALUE;

        int maxGap = 0;

        for(int i=0; i<=max; i++){
            if(hasNumArray[i]){
                if(lastIndex == Integer.MIN_VALUE){
                    lastIndex = i;
                }else {
                    if(i - lastIndex > maxGap){
                        maxGap = i - lastIndex;
                    }
                    lastIndex = i;
                }
            }
        }

        return maxGap;
    }

    public static void main(String[] args){
        int[] test = {1,99999999};
        System.out.println(new MaximumGap().maximumGap(test));
    }
}
