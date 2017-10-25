package LinkedList;
//Given a singly linked list, determine if it is a palindrome.
//
//Follow up:
//Could you do it in O(n) time and O(1) space?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        ListNode pre = mid;
        //slow.next = null;
        while (pre!=null && pre.next!=null){
            ListNode next = pre.next;
            pre.next = next.next;
            next.next = slow.next;
            slow.next = next;
        }
        ListNode current = head;
        //ListNode midcurrent = mid;
        while (slow.next!=null){
            slow = slow.next;
            if (current.val!=slow.val) return false;
            current = current.next;
        }
        return true;
    }
}
