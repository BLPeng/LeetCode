package LinkedList;
//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatefromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast!=null){
            while (fast.next!=null && fast.val==fast.next.val) fast = fast.next;
            if (slow.next==fast) slow = slow.next;
            else slow.next = fast.next;
            fast = fast.next;
        }
        return dummy.next;
    }
}
