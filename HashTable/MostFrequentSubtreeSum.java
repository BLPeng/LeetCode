package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
//
//Examples 1
//Input:
//
//  5
// /  \
//2   -3
//return [2, -3, 4], since all the values happen only once, return all of them in any order.
//Examples 2
//Input:
//
//  5
// /  \
//2   -5
//return [2], since 2 happens twice, however -5 only occur once.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MostFrequentSubtreeSum {
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {
        int a = helper(root);
        int max = 0;
        for (int value : hm.values()) max = Math.max(max,value);
        List<Integer> l = new ArrayList<Integer>();
        for (int key : hm.keySet()) {
            if (hm.get(key)==max) l.add(key);
        }
        int[] result = new int[l.size()];
        for (int i=0; i<l.size(); i++) result[i]=l.get(i);
        return result;
    }
    public int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = root.val + left + right;
        hm.put(sum, hm.getOrDefault(sum,0)+1);
        return sum;
    }
}
