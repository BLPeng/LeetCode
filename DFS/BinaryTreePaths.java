package DFS;
//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<String>();
        helper(root, l, "");
        return l;
    }
    public void helper(TreeNode root, List<String> l, String result){
        if (root==null) return;
        if (root.left==null && root.right==null) {
            result += root.val;
            l.add(result);
            return;
        }
        helper(root.left, l, result+root.val+"->");
        helper(root.right, l, result+root.val+"->");
    }
}
