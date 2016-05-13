package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by haodongl on 12/4/15.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> tmp = new ArrayList<Integer>();

        if(nums.length ==0 || k==0){
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<Integer>();

        for(int i=0; i<k && i < nums.length; i++){
            if(deque.isEmpty()){
                deque.addLast(nums[i]);
            }else {
                while (!deque.isEmpty()&&deque.peekLast() < nums[i]){
                    deque.pollLast();
                }
                if( deque.isEmpty() || nums[i] <= deque.peekLast() ){
                    deque.addLast(nums[i]);
                }
            }
        }

        tmp.add(deque.peekFirst());

        for(int i=k; i<nums.length; i++){

            if(nums[i-k] == deque.peekFirst()){
                deque.pollFirst();
            }

            while (!deque.isEmpty()&&deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            if(deque.isEmpty() || nums[i] <= deque.peekLast()){
                deque.addLast(nums[i]);
            }

            tmp.add(deque.peekFirst());
        }

        int[] result = new int[tmp.size()];

        int i=0;
        for(int num : tmp){
            result[i] = num;
            i++;
        }

        return result;
    }

    public static void main(String[] args){
        int[] num = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        for(int i : new SlidingWindowMaximum().maxSlidingWindow(num, k)){
            System.out.println(i);
        }

    }

}
