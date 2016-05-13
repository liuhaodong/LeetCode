package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
    public ListNode mergeKLists(List<ListNode> lists) {
    	Comparator<ListNode> nodeComparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		};
		
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), nodeComparator);
    	
    	for (ListNode tmpNode : lists) {
    		if (tmpNode == null) {
				continue;
			}
			queue.offer(tmpNode);
		}
    	
    	ListNode resultNodeEnd = null;
    	ListNode resultNode =  null;
    	
    	while(!queue.isEmpty()){
    		ListNode nextNode = queue.poll();
    		if (nextNode.next != null) {
				queue.offer(nextNode.next);
			}
    		
    		if (resultNode == null) {
				resultNode = nextNode;
				resultNodeEnd = nextNode;
			}else {
				resultNodeEnd.next = nextNode;
				resultNodeEnd = resultNodeEnd.next;
			}	
    	}
        return resultNode;
    }
    
    public static void main(String[] args){
    	MergeKSortedLists test = new MergeKSortedLists();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(8983);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(-23);
    	n1.next = n3;
    	n2.next = n4;
    	n3.next = new ListNode(7);
    	List<ListNode> testList = new LinkedList<ListNode>();
    	testList.add(null);
    	testList.add(n2);
       	ListNode result = test.mergeKLists(testList);
    	while(result!=null){
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
    
}
