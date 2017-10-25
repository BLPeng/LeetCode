package LinkedList;
//You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Follow up:
//What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//
//Example:
//
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while (l1!=null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2!=null){
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode result = new ListNode(-1);
        ListNode current = result;
        int more = 0;
        int d1 = 0;
        int d2 = 0;
        while (!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) d1 = s1.pop().val;
            else d1=0;
            if(!s2.isEmpty()) d2 = s2.pop().val;
            else d2=0;
            int sum = d1+d2+more;
            more = sum>=10 ? 1 : 0;
            ListNode temp = new ListNode(sum%10);
            temp.next = current.next;
            current.next = temp;
        }
        if (more==1){
            ListNode temp = new ListNode(1);
            temp.next = current.next;
            current.next = temp;
        }
        return result.next;
    }
}
