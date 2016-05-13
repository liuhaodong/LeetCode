package leetcode.sort;

/**
 * Created by haodongl on 12/28/15.
 */
public class HeapSort<T extends Comparable> {

    private void maxHeapify(T[] array, int index, int size){
        int l = leftIndex(index);
        int r = rightIndex(index);

        int large = index;

        if(l < size && array[large].compareTo(array[l]) < 0 ){
            large = l;
        }
        if(r < size && array[large].compareTo(array[r]) < 0){
            large = r;
        }
        if(large != index){
            T tmp = array[index];
            array[index] = array[large];
            array[large] = tmp;
            maxHeapify(array, large, size);
        }
    }

    public void buildMaxHeap(T[] array){
        for(int i = parentIndex(array.length - 1); i>=0; i--){
            maxHeapify(array, i, array.length);
        }
    }

    private int leftIndex(int index){
        return (index + 1)*2 - 1;
    }

    private int rightIndex(int index){
        return (index + 1)*2;
    }

    private int parentIndex(int index){
        return (index - 1)/2 ;
    }

    public void sort(T[] array){
        buildMaxHeap(array);
        int heapSize = array.length;
        while (heapSize >=2){
            T tmp = array[heapSize - 1];
            array[heapSize - 1] = array[0];
            array[0] = tmp;
            heapSize--;
            maxHeapify(array, 0, heapSize);
        }
    }

    public static void main(String[] args){
        Integer[] test = {3,1,4,5,2};
        HeapSort<Integer> heapSort = new HeapSort<Integer>();
        heapSort.sort(test);
        for(int tmp : test){
            System.out.println(tmp);
        }
    }

}
