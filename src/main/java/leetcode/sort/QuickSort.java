package leetcode.sort;

/**
 * Created by haodongl on 12/17/15.
 */
public class QuickSort {

    public static void sort(double[] nums){
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(double[] nums, int left, int right){

        if(right - left <=0){
            return;
        }

        int pivotIndex = partition(nums, left, right);
        sort(nums, left, pivotIndex - 1);
        sort(nums, pivotIndex + 1, right);
    }

    public static int partition(double[] nums, int left, int right){

        double pivot = nums[right];

        int leftIndex = left;
        int rightIndex = right;

        while (rightIndex > leftIndex){
            double current = nums[rightIndex - 1];
            if(current > pivot){
                nums[rightIndex] = nums[rightIndex - 1];
                rightIndex--;
            }else {
                double tmp = nums[leftIndex];
                nums[leftIndex] = current;
                nums[rightIndex -1] = tmp;
                leftIndex++;
            }

        }

        nums[rightIndex] = pivot;

        return rightIndex;
    }

    public static void main(String[] args){
        double[] test = {1.1,2.2};
        QuickSort.sort(test);
        for(double num : test) {
            System.out.println(num);
        }
    }
}
