package leetcode;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//		Each element in the array represents your maximum jump length at that position.
//
//		Determine if you are able to reach the last index.
//
//		For example:
//		A = [2,3,1,1,4], return true.
//
//		A = [3,2,1,0,4], return false.

public class JumpGame {

	public boolean canJump(int[] nums) {

		if(nums.length==0){
			return true;
		}

		int remainingSteps = nums[0];
		for(int i=0; i < nums.length; i++){
			if(remainingSteps < 0) return false;
			if(nums[i] > remainingSteps){
				remainingSteps = nums[i];
			}
			remainingSteps--;
		}

		return true;
	}
	
	public static void main(String[] args){
		JumpGame test = new JumpGame();
		int[] array = new int[]{0};
		System.out.println(test.canJump(array));
	}
	
}
