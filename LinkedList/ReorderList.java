package LinkedList;
//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//You must do this in-place without altering the nodes' values.
//
//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList {
	public void reorderList(ListNode head) {
        if (head==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode head2 = null;
        ListNode last = mid;
        while (last!=null){ //reverse后半段
            ListNode temp = last.next;
            last.next = head2;
            head2 = last;
            last = temp;
        }
        while (head!=null && head2!=null){
            ListNode temp = head.next;
            head.next = head2;
            head2 = head2.next;
            head.next.next = temp;
            head = temp;
        }
    }
}
