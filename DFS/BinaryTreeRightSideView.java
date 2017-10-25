package DFS;
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        helper(root, l, 0);
        return l;
    }
    public void helper(TreeNode root, List<Integer> l, int level){
        if (root==null) return;
        if (l.size()<=level){
            l.add(level,root.val);
        }
        helper(root.right, l, level+1);
        helper(root.left, l, level+1);
    }
}
