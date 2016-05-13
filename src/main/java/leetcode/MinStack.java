package leetcode;

import java.util.ArrayList;

public class MinStack {
	
	public ArrayList<Integer> minValueStack = new ArrayList<Integer>();
	
	public ArrayList<Integer> minStack = new ArrayList<Integer>();
	
    public void push(int x) {
    	if (minValueStack.size()==0) {
			minValueStack.add(x);
			minStack.add(x);
		}else if (x <= minValueStack.get(minValueStack.size() -1)) {
			minValueStack.add(x);
			minStack.add(x);
		}else {
			minStack.add(x);
		}
    }

    public void pop() {
    	if (minStack.isEmpty()) {
			return;
		}
        if (minStack.get(minStack.size() - 1).intValue() == minValueStack.get(minValueStack.size() -1).intValue()) {
			minStack.remove(minStack.size() - 1);
			minValueStack.remove(minValueStack.size() - 1);
		}else {
			minStack.remove(minStack.size() - 1);
		}
    }

    public int top() {
    	if (minStack.isEmpty()) {
    		return 0;
		}
    	return minStack.get(minStack.size() - 1);
    }

    public int getMin() {
    	if (minValueStack.isEmpty()) {
			return 0;
		}
        return minValueStack.get(minValueStack.size() - 1);
    }
    
    public static void main(String[] args){
    	MinStack test = new MinStack();
    	test.push(512);
    	test.push(-1024);
    	test.push(-1024);
    	test.push(512);
    	System.out.println(test.minStack.size());
    	System.out.println(test.minValueStack.size());
    	test.pop();
    	System.out.println(test.getMin());
    	System.out.println(test.minStack.size());
    	System.out.println(test.minValueStack.size());
    	test.pop();
    	System.out.println(test.getMin());
    	System.out.println(test.minStack.size());
    	System.out.println(test.minValueStack.size());
    	test.pop();
    	System.out.println(test.getMin());
    	System.out.println(test.minStack.size());
    	System.out.println(test.minValueStack.size());
    }
    
}
