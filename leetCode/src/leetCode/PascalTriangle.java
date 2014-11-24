package leetCode;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList < ArrayList<Integer>> generate(int numRows) {
    	ArrayList < ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	if (numRows == 0) {
			return list;
		}
    	
    	ArrayList<Integer> row1 = new ArrayList<Integer>();
    	ArrayList<Integer> row2 = new ArrayList<Integer>();
    	ArrayList<Integer> row3 = new ArrayList<Integer>();
    	row1.add(1);
    	row2.add(1);
    	row2.add(1);
    	list.add(row1);
    	if (numRows == 1) {
			return list;
		}
    	list.add(row2);
    	if (numRows == 2) {
			return list;
		}
    	for (int i = 3; i <= numRows; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			int j = 1;
			while(j<i-1){
				tmp.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
				j++;
			}
			tmp.add(1);
			list.add(tmp);
		}
		return list;
    }
    
    public static void main(String [] args){
    	System.out.println(new PascalTriangle().generate(5));
    }
}
