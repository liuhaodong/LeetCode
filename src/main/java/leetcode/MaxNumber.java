package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by haodongl on 4/5/16.
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums2 == null){
            return new int[0];
        }

        int index1 = nums1.length - ( (k - nums2.length) > 0 ? (k - nums2.length) : 1 );
        int index2 = nums2.length - ( (k - nums1.length) > 0 ? (k - nums1.length) : 1 );

        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();

        for(int i=0; i <= index1; i++){
            pushQueue(queue1, nums1[i]);
        }

        for(int i=0; i <= index2; i++){
            pushQueue(queue2, nums2[i]);
        }

        for(int i=0; i<k; i++){
            int cand1 = Integer.MIN_VALUE;
            int cand2 = Integer.MIN_VALUE;
            if(!queue1.isEmpty()) cand1 = queue1.peekFirst();
            if(!queue2.isEmpty()) cand2 = queue2.peekFirst();
            if(cand1 > cand2){
                result.add(queue1.pollFirst());
                index1++;
                if(index1 < nums1.length){
                    pushQueue(queue1, nums1[index1]);
                }
            }else if(cand1 < cand2) {
                result.add(queue2.pollFirst());
                index2++;
                if(index2 < nums2.length){
                    pushQueue(queue2, nums2[index2]);
                }
            } else if(cand1 == cand2){
                int next1 = Integer.MIN_VALUE;
                int next2 = Integer.MIN_VALUE;

                if(index1+1 < nums1.length) next1 = nums1[index1 + 1];
                if(index2 + 1 < nums2.length) next2 = nums2[index2 + 1];

                if(next1 > next2){
                    result.add(queue1.pollFirst());
                    index1++;
                    if(index1 < nums1.length){
                        pushQueue(queue1, nums1[index1]);
                    }
                }else{
                    result.add(queue2.pollFirst());
                    index2++;
                    if(index2 < nums2.length){
                        pushQueue(queue2, nums2[index2]);
                    }
                }
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }


    private void pushQueue(Deque<Integer> queue, int num){
        if(!queue.isEmpty()){
            while( !queue.isEmpty() && queue.peekLast() < num){
                queue.pollLast();
            }
        }
        queue.add(num);
    }

    public static void main(String[] args){
        MaxNumber test = new MaxNumber();
        int[] nums1 = {3,9};
        int[] nums2 = {8,9};
        int[] result = test.maxNumber(nums1, nums2, 3);
        for(int n : result){
            System.out.println(n);
        }
    }
}
