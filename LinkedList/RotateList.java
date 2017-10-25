package LinkedList;
//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (k==0 || head==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode fast = head;
        ListNode slow = head;
        int count=1;
        while(fast.next!=null){
            fast = fast.next;
            count++;
        }
        int a = count-(k%count);
        if (a==count) return head;
        while (slow.next!=null && a>1){
            slow = slow.next;
            a--;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
}
