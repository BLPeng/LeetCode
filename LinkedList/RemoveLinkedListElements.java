package LinkedList;
//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode pre = dummy;
        while (current!=null){
            if (current.val==val){
                ListNode temp = current.next;
                pre.next = current.next;
                current = temp;
            } else {
                pre = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
