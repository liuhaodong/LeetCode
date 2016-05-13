package leetcode;

/**
 * Created by haodongl on 12/16/15.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Subscribe to see which companies asked this question
 */
public class JumpGameII {


    public int jump(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int[] minStep = new int[nums.length];

        for(int i=0; i< nums.length ; i++){
            minStep[i] = Integer.MAX_VALUE;
        }

        minStep[0] = 0;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if( nums[j] < i - j){
                    continue;
                }else if(minStep[j] + 1< minStep[i]){
                    minStep[i] = minStep[j]+1;
                    break;
                }
            }
        }

        return minStep[nums.length - 1];
    }

    public static void main(String[] args){
        int[] test = {2,3,1,1,4,1,1,1};
        System.out.println(new JumpGameII().jump(test));
    }

}
