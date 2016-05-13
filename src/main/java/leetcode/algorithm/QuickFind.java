package leetcode.algorithm;

/**
 * Created by haodongl on 4/5/16.
 */
public class QuickFind {
    public int find(int[] num, int n){
        return select(num, 0, num.length-1, n -1);
    }

    public void sort(int[] num){
        sort(num, 0, num.length-1);
    }

    private int select(int[] num, int left, int right, int n){
        if(left == right) return num[left];
        int pivotIndex = right;
        int storeIndex = partition(num, left, right, pivotIndex);
        if(storeIndex == n){
            return num[n];
        }else if(storeIndex < n){
            return select(num, storeIndex+1, right, n);
        }else {
            return select(num, left, storeIndex-1, n);
        }
    }

    private void sort(int[] num, int left, int right){
        int pivotIndex = partition(num, left, right, right);
        if(pivotIndex != left){
            sort(num, left, pivotIndex-1);
        }
        if(pivotIndex != right){
            sort(num, pivotIndex+1, right);
        }
    }

    private int partition(int[] num, int left, int right, int pivotIndex){
        int pivotValue = num[pivotIndex];

        num[pivotIndex] = num[right];
        num[right] = pivotValue;

        int storeIndex = left;
        for(int i=left; i<right; i++){
            if(num[i] < pivotValue){
                int tmp = num[storeIndex];
                num[storeIndex] = num[i];
                num[i] = tmp;
                storeIndex++;
            }
        }

        num[right] = num[storeIndex];
        num[storeIndex] = pivotValue;
        return storeIndex;
    }

    public static void main(String[] args){
        int[] test = {3,2,6,1,5};
        QuickFind qf = new QuickFind();
        qf.sort(test);
        System.out.println();
    }

}
