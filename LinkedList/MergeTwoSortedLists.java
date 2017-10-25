package LinkedList;
//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (current1!=null && current2!=null){
            if (current1.val<current2.val){
                current.next = new ListNode(current1.val);
                current1 = current1.next;
            }
            else {
                current.next = new ListNode(current2.val);
                current2 = current2.next;
            }
            current = current.next;
        }
        current.next = (current1==null) ? current2 : current1;
        return dummy.next;
    }
}
