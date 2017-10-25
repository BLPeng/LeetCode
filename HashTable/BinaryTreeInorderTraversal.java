package HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//For example:
//Given binary tree [1,null,2,3],
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root==null) return l;
        TreeNode temp = root;
        while (!s.isEmpty() || temp!=null){
            while (temp!=null) {
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            l.add(temp.val);
            //if (temp.right!=null) s.push(temp.right); 不能用这一步，因为temp节点必须移动！
            temp = temp.right;
        }
        return l;
    }
}
