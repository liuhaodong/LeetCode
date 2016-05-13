package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haodongl on 3/5/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return result;
        for(int current : candidates){
            if(current == target || (2*current <= target)){
                List<Integer> currentList = new ArrayList<>();
                currentList.add(current);
                dfsUtil(candidates, target - current, currentList, result);
            }
        }
        return result;
    }

    private void dfsUtil(int[] candidates, int target, List<Integer> current, List<List<Integer>> result){
        if(target == 0){
            result.add(current);
            return;
        }else{
            int last = current.get(current.size() -1 );
            for(int next : candidates){
                if(next >= last && (target == next || 2*next <= target)){
                    List<Integer> nextLevel = new ArrayList<>(current);
                    nextLevel.add(next);
                    dfsUtil(candidates, target - next, nextLevel, result);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] candidates = {1,2};
        CombinationSum test = new CombinationSum();
        List<List<Integer>> result = test.combinationSum(candidates, 3);

    }
}
