package leetcode;

/**
 * Created by haodongl on 4/15/16.
 */
public class MedianTwoSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0;
        if( (nums1.length + nums2.length)%2 == 1 ){
            return findKthNum(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length)/2 + 1);
        }else{
            return (findKthNum(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length)/2) + findKthNum(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length)/2 + 1) )/2.0;
        }
    }

    public int findKthNum(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2, int k){
        if(len1 > len2){
            return findKthNum(nums2, start2, len2, nums1, start1, len1, k);
        }
        if(len1 == 0){
            return nums2[start2 + k -1];
        }
        if(k==1) return (nums1[start1] < nums2[start2])? nums1[start1]:nums2[start2];
        int partition1 = (k/2 < len1)? k/2 : len1;
        int partition2 = k - partition1;
        if(nums1[ start1+ partition1 -1] < nums2[start2 + partition2 - 1]){
            return findKthNum(nums1, start1 + partition1, len1 - partition1, nums2, start2, len2, k - partition1);
        }else if(nums1[ start1+ partition1 -1] > nums2[start2 + partition2 - 1]){
            return findKthNum(nums1, start1, len1, nums2, start2 + partition2, len2 - partition2, k - partition2);
        }else{
            return nums1[ start1+ partition1 -1];
        }
    }

    public static void main(String[] args){
        int[] a1 = {1};
        int[] a2 = {};
        System.out.println(new MedianTwoSorted().findMedianSortedArrays(a1, a2));
    }
}
