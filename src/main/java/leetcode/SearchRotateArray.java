package leetcode;

/**
 * Created by haodongl on 4/20/16.
 */
public class SearchRotateArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int pivot = findPivot(nums, 0, nums.length -1);
        int a = binarySearch(nums, 0, pivot -1, target);
        int b = binarySearch(nums, pivot, nums.length -1, target);
        if(a != -1){
            return a;
        }else if(b != -1) return b;
        else return -1;
    }

    private int findPivot(int[] nums, int start, int end){
        int low = start;
        int high = end;
        while (high > low){
            int mid = (high + low)/2;
            if(nums[mid] > nums[high]) low = mid +1;
            else high = mid;
        }
        return low;
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        int low = start;
        int high = end;
        while(high >= low){
            int mid = low + (high - low)/2;
            if(target < nums[mid]) high = mid - 1;
            else if(target > nums[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] test = {5,1,3};
        System.out.println(new SearchRotateArray().search(test, 1));
    }
}
