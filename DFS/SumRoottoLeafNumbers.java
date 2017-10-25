package DFS;
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//For example,
//
//    1
//   / \
//  2   3
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//
//Return the sum = 12 + 13 = 25.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRoottoLeafNumbers {
	int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper(TreeNode root, int num) {
        if (root==null) return;
        num += root.val;
        if (root.left==null && root.right==null){
            sum += num;
        }
        helper(root.left, num*10);
        helper(root.right, num*10);
        num /= 10;
    }
}
