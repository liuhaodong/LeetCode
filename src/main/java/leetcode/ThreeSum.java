package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by haodongl on 10/29/15.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);

        Set<Integer> checkedSet = new HashSet<>();
        for(int i=0; i <= nums.length -3; i++){
            int a = nums[i];
            if(checkedSet.contains(a) ) continue;
            checkedSet.add(a);
            int start = i+1;
            int end = nums.length -1;
            while(end > start){
                int b = nums[start];
                int c = nums[end];
                if(a + b + c == 0){
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(a);
                    tuple.add(b);
                    tuple.add(c);
                    result.add(tuple);
                    while(b == nums[start] && start < end){
                        start++;
                    }
                    while(c == nums[end] && start < end){
                        end--;
                    }
                }else if(a+b+c > 0){
                    while(c == nums[end] && start< end ){
                        end--;
                    }
                }else {
                    while(b == nums[start] && start < end){
                        start++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] test = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        ThreeSum sum = new ThreeSum();
        List<List<Integer>> result = sum.threeSum(test);
        for(List<Integer> l : result){
            System.out.println(l);
        }
    }
}
