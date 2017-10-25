package LinkedList;
//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count=0;
        while (count!=m){
            slow = fast;
            fast = fast.next;
            count++;
        }
        int count1 = n-m;
        while (fast!=null && fast.next!=null && count1!=0){ //节点fast会跟随位置变化
            ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = temp;
            count1--;
        }
        return dummy.next;
    }
}
