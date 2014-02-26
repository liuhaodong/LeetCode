package leetCode;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
    	if (head == null) {
			return head;
		}else if (head.next==null) {
			return head;
		}else if (head.next.next==null) {
			ListNode tmp = head.next;
			head.next.next= head;
			head.next=null;
			return tmp;
		}else {
			ListNode tmp = head.next;
			ListNode tmp1 = tmp.next;
			head.next.next = head;
			head.next = swapPairs(tmp1);
			return tmp;
		}
    }
    
    public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode tmp = new SwapNodes().swapPairs(node1);
		while(tmp!=null){
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}
    
}
