package BinarySearch;
//Given a complete binary tree, count the number of nodes.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int left = helper1(root.left);
        int right = helper2(root.right);
        if (left==right) return (int)Math.pow(2,left)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int helper1(TreeNode root){
        if (root==null) return 0;
        return 1+helper1(root.left);
    }
    public int helper2(TreeNode root){
        if (root==null) return 0;
        return 1+helper2(root.right);
    }
}
