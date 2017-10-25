package LinkedList;
//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode temp1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode temp2 = dummy2;
        ListNode current = head;
        while (current!=null){
            if (current.val<x) {
                temp1.next = current;
                temp1 = temp1.next;
            } else {
                temp2.next = current;
                temp2 = temp2.next;
            }
            current = current.next;
        }
        temp1.next = dummy2.next;
        temp2.next = null;
        return dummy1.next;
    }
}
