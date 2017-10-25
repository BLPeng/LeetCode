package DFS;
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
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
public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        helper(root, ll, new ArrayList<Integer>(), sum);
        return ll;
    }
    public void helper(TreeNode root, List<List<Integer>> ll, List<Integer> l, int sum){
        if (root==null) return;
        l.add(root.val);
        if (root.left==null && root.right==null && sum==root.val){
            ll.add(new ArrayList<Integer>(l));
        }
        helper(root.left, ll, l, sum-root.val);
        helper(root.right, ll, l, sum-root.val);
        l.remove(l.size()-1);
    }
}
