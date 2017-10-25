package BFS;
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        helper(root, ll, 0);
        return ll;
    }
    public void helper(TreeNode root, List<List<Integer>> ll, int level){
        if (root==null) return;
        if (ll.size()<=level) ll.add(0,new ArrayList<Integer>());
        ll.get(ll.size()-level-1).add(root.val);
        helper(root.left, ll, level+1);
        helper(root.right, ll, level+1);
    }
}
