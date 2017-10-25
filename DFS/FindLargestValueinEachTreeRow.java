package DFS;

import java.util.ArrayList;
import java.util.List;

//You need to find the largest value in each row of a binary tree.
//
//Example:
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindLargestValueinEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        helper(root, l, 0);
        return l;
    }
    public void helper(TreeNode root, List<Integer> l, int level){
        if (root==null) return;
        if (level>=l.size()) l.add(root.val);
        l.set(level,Math.max(root.val,l.get(level)));
        helper(root.left, l, level+1);
        helper(root.right, l, level+1);
    }
}
