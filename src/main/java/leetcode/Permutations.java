package leetcode;

import java.util.ArrayList;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	list = permute(num, 0, num.length-1);
		return list;
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num, int start, int end) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	if (end<start) {
			return list;
		}
    	if (start == end) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(num[start]);
			list.add(tmp);
			return list;
		}
    	ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
    	list1 = permute(num, start+1, end);
    	for (int i = 0; i < list1.size(); i++) {
    		ArrayList<Integer> tmp = list1.get(i);
    		int length = tmp.size();
    		for (int j = 0; j < length+1; j++) {
    			ArrayList<Integer> tmp1 = new ArrayList<Integer>(tmp);

    			tmp1.add(j,num[start]);
				list.add(tmp1);
			}
		}
    	
		return list;
    }
    
    public static void main(String[] args) {
    	int [] num = {};
		System.out.println(new Permutations().permute(num));
	}
}
