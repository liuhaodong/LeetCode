package leetcode.sort;

/**
 * Created by haodongl on 12/28/15.
 */
public class CountSort {
    public static int[] sort(int[] array, int max){
        int[] countArray = new int[max + 1];
        int[] resultArray = new int[array.length];

        for(int num : array){
            countArray[num]++;
        }

        for(int i=1; i <= max; i++){
            countArray[i] += countArray[i-1];
        }

        for(int i=array.length - 1; i>=0; i--){
            resultArray[countArray[array[i]]-1] = array[i];
            countArray[array[i]]--;
        }
        return resultArray;
    }

    public static void main(String[] args){
        int[] array = {5,4,3,2,1,0,3424,2345,11,4236,1234,16,4235};
        int[] result = CountSort.sort(array, 4236);
        for(int num : result){
            System.out.println(num);
        }
    }
}
