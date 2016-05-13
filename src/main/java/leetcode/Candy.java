package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by haodongl on 12/9/15.
 */

//There are N children standing in a line. Each child is assigned a rating value.
//
//        You are giving candies to these children subjected to the following requirements:
//
//        Each child must have at least one candy.
//        Children with a higher rating get more candies than their neighbors.
//        What is the minimum candies you must give?
//
//        Subscribe to see which companies asked this question

public class Candy {
    public int candy(int[] ratings) {

        Map<Integer, Integer> candyNumMap = new HashMap<Integer, Integer>();

        if(ratings.length == 1){
            return 1;
        }else if(ratings.length == 0){
            return 0;
        }

        for(int i=0; i< ratings.length; i++){
            if( i - 1 >=0 && i + 1 < ratings.length && (ratings[i-1] >= ratings[i]) && (ratings[i+1] >= ratings[i])){
                candyNumMap.put(i, 1);
            }else if(i==0 && ratings[i] <= ratings[i+1]){
                candyNumMap.put(i, 1);
            }else if(i== ratings.length - 1 && ratings[i - 1]>= ratings[i]){
                candyNumMap.put(i, 1);
            }
        }

        Set<Integer> indexSet = new HashSet<Integer>(candyNumMap.keySet());

        for(int index : indexSet){
            for(int i= index; i<ratings.length - 1; i++){
                if(!candyNumMap.containsKey(i+1) && ratings[i+1] > ratings[i]){
                    candyNumMap.put(i+1, candyNumMap.get(i)+1);
                }else {
                    break;
                }
            }
        }

        for(int index : indexSet){
            for(int i=index; i>0; i--){
                if(!candyNumMap.containsKey(i-1) && ratings[i-1] > ratings[i]){
                    candyNumMap.put(i-1, candyNumMap.get(i)+1);
                }else if(candyNumMap.containsKey(i-1) && ratings[i-1] > ratings[i] && candyNumMap.get(i-1) <= candyNumMap.get(i)){
                    candyNumMap.put(i-1, candyNumMap.get(i)+1);
                }else {
                    break;
                }
            }
        }

        int result =0;

        for(int tmp : candyNumMap.values()){
            result += tmp;
        }

        return result;
    }

    public static void main(String[] args){
        int test[] = {1,3,4,3,2,1};
        System.out.println(new Candy().candy(test));
    }
}
