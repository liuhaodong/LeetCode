package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by haodongl on 12/3/15.
 */
public class DataStreamMedian {

    PriorityQueue<Integer> rightQueue = new PriorityQueue<Integer>();
    PriorityQueue<Integer> leftQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });


    // Adds a number into the data structure.
    public void addNum(int num) {
        if(rightQueue.size() == leftQueue.size()){
            if(rightQueue.size() == 0){
                rightQueue.add(num);
            }else {
                if(num >= rightQueue.peek() || (num < rightQueue.peek() && num > leftQueue.peek())){
                    rightQueue.add(num);
                } else {
                    rightQueue.add(leftQueue.remove());
                    leftQueue.add(num);
                }
            }
        }else if(rightQueue.size() > leftQueue.size()){
            if(num > rightQueue.peek()){
                leftQueue.add(rightQueue.remove());
                rightQueue.add(num);
            }else {
                leftQueue.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(rightQueue.size() > leftQueue.size()) return rightQueue.peek();
        else return (rightQueue.peek() + leftQueue.peek())/2.0;
    }

    public static void main(String[] args){
        DataStreamMedian test = new DataStreamMedian();
        test.addNum(-1);
        test.addNum(-2);
//        test.addNum(-3);
        System.out.println(test.findMedian());
    }
}
