package leetcode;

/**
 * Created by haodongl on 11/24/15.
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        return false;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null, cur = head;
        while (head.next != null){
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }
        head.next = prev;
        return head;
    }

    public ListNode getNode(ListNode head, int index) {
        ListNode result = head;
        for(int i=0; i< index ; i++){
            result = result.next;
        }
        return result;
    }

}
