package BFS;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
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
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        helper(root, ll, 0);
        return ll;
    }
    public void helper(TreeNode root, List<List<Integer>> ll, int level){
        if (root==null) return;
        if (ll.size()<=level) ll.add(new ArrayList<Integer>());
        if (level%2==0) ll.get(level).add(root.val);
        else ll.get(level).add(0,root.val);
        helper(root.left, ll, level+1);
        helper(root.right, ll, level+1);
    }
}
