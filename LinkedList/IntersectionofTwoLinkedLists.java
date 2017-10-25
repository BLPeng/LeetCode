package LinkedList;
//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//For example, the following two linked lists:
//
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//begin to intersect at node c1.
//
//
//Notes:
//
//If the two linked lists have no intersection at all, return null.
//The linked lists must retain their original structure after the function returns.
//You may assume there are no cycles anywhere in the entire linked structure.
//Your code should preferably run in O(n) time and use only O(1) memory.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        int a = helper(headA);
        int b = helper(headB);
        int c = Math.abs(a-b);
        if (a>b){
            for (int i=0; i<c; i++) headA=headA.next;
        } else {
            for (int i=0; i<c; i++) headB=headB.next;
        }
        while (headA!=null && headB!=null && headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    public int helper(ListNode head){
        int count=1;
        while (head!=null && head.next!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}
