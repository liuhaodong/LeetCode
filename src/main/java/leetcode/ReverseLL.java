package leetcode;

/**
 * Created by haodongl on 11/24/15.
 */
public class ReverseLL {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null) return null;

        int index = 1;

        while(head.next != null){
            head = head.next;
            index ++;
        }

        return null;
    }

    public ListNode reverse(ListNode head, int l){
        int i =0;
        ListNode cur = head;
        ListNode prev = null;
        while (i < l){
            head = head.next;

            l++;
        }
        head.next = prev;
        return null;
    }

}
