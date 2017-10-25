package LinkedList;
//Sort a linked list using insertion sort.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (head!=null){
            ListNode temp = head.next;
            current = dummy;
            while (current.next!=null && current.next.val<=head.val){
                current = current.next;
            }
            head.next = current.next;
            current.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
