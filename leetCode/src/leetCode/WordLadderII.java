package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordLadderII {
	
	public static boolean isAdjancent(String str1, String str2){
		int count = 0;
		if (str1.length() != str2.length()) {
			return false;
		}else {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					if(count == 0) count++;
					else return false;
				}
			}
		}
		return count==1;
	}
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	
    	HashMap<String, Integer> stepCountMap = new HashMap<String, Integer>();
    	stepCountMap.put(end, isAdjancent(start, end)? 1: Integer.MAX_VALUE);
    	
    	for (String tmpString : dict) {
			if (isAdjancent(start, tmpString)) {
				stepCountMap.put(tmpString, 1);
			}else {
				stepCountMap.put(tmpString, Integer.MAX_VALUE);
			}
		}
    	
    	int currentMaxStep = 1;
    	
    	while(stepCountMap.get(end).equals(Integer.MAX_VALUE)){
    		boolean flag = false;
    		for(Entry<String, Integer> tmpEntry : stepCountMap.entrySet()){
    			if (tmpEntry.getValue().intValue() == currentMaxStep) {
    				flag = true;
    				//Update stepCountMap
    				for(Entry<String, Integer> tmpUpdateEntry : stepCountMap.entrySet()){
    					if (!tmpEntry.getKey().equals(tmpUpdateEntry.getKey()) && isAdjancent(tmpEntry.getKey(), tmpUpdateEntry.getKey()) && (tmpEntry.getValue().intValue() +1) < tmpUpdateEntry.getValue().intValue() ) {
							stepCountMap.put(tmpUpdateEntry.getKey(), currentMaxStep + 1);
						}
    				}
				}
    		}
    		if (flag == false) {
				return null;
			}
    		currentMaxStep = currentMaxStep + 1;
    	}
    	
    	List<List<String>> resultList = new LinkedList<List<String>>();
    	
    	
        return null;
    }
    
    public static void main(String[] args){
    	WordLadderII test = new WordLadderII();
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	test.findLadders("hit","cog", dict);
    }
}
