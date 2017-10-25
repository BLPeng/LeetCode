package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
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
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
	    //     List<List<Integer>> ll = new ArrayList<List<Integer>>();
	    //     helper(root, ll, 0);
	    //     return ll;
	    // }
	    // public void helper(TreeNode root, List<List<Integer>> ll, int level){
	    //     if (root==null) return;
	    //     if (ll.size()<=level) ll.add(new ArrayList<Integer>());
	    //     ll.get(level).add(root.val);
	    //     helper(root.left, ll, level+1);
	    //     helper(root.right, ll, level+1);
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        List<List<Integer>> ll = new ArrayList<List<Integer>>();
	        if (root==null) return ll;
	        q.add(root);
	        int level=0;
	        while (!q.isEmpty()){
	            int size = q.size();
	            if (ll.size()<=level) ll.add(new ArrayList<Integer>());
	            for (int i=0; i<size; i++){
	                TreeNode temp = q.poll();
	                ll.get(level).add(temp.val);
	                if (temp.left!=null) q.add(temp.left);
	                if (temp.right!=null) q.add(temp.right);
	            }
	            level++;
	        }
	        return ll;
	    }
}
