package LinkedList;
//Reverse a singly linked list.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    public ListNode reverse(ListNode head, ListNode head1){
        if (head==null) return head1;
        ListNode temp = head.next;
        head.next = head1;
        return reverse(temp, head);
    }
}
