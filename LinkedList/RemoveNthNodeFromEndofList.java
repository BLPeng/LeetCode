package LinkedList;
//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode current = head;
        int count=0;
        while (current!=null){
            count++;
            current = current.next;
        }
        int a = count-n;
        if (a==0) return dummy.next.next;
        while (a>0){
            slow = fast;
            fast = fast.next;
            a--;
        }
        slow.next = fast.next; //删除操作只需要这一步；
        return dummy.next;
    }
}
