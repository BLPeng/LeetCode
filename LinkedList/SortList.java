package LinkedList;
//Sort a linked list in O(n log n) time using constant space complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
	public ListNode sortList(ListNode head) { //分治排序
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = slow.next;
        slow.next = null;
        return helper(sortList(head),sortList(head1));
    }
    public ListNode helper(ListNode head, ListNode head1) {
        ListNode dummy1 = new ListNode(0);
        ListNode current = dummy1;
        while (head!=null && head1!=null){
            if (head.val<head1.val){
                current.next = head;
                head = head.next;
            } else {
                current.next = head1;
                head1 = head1.next;
            }
            current = current.next;
        }
        if (head!=null) current.next = head;
        if (head1!=null) current.next = head1;
        return dummy1.next;
    }
}
