package BinarySearch;
//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementinaBST {
	// public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> s = new Stack<TreeNode>();
    //     int count = 1;
    //     TreeNode temp = root;
    //     while (temp!=null || !s.isEmpty()){
    //         while (temp!=null){
    //             s.push(temp);
    //             temp = temp.left;
    //         }
    //         temp = s.pop();
    //         count++;
    //         if (count == k) return temp.val;
    //         if (temp.right!=null) s.push(temp.right);
    //     }
    //     return -1;
    // }
    //int count=0, result=0;
	public int kthSmallest(TreeNode root, int k) {
		int count = helper(root.left);
		if (k<=count) return kthSmallest(root.left, k);
		else if (k>count+1) return kthSmallest(root.right, k-1-count);
		return root.val;
    }
	public int helper(TreeNode root){
		if (root==null) return 0;
		return 1+helper(root.left)+helper(root.right);
	}
}
