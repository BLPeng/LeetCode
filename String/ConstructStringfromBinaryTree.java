package String;
//You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//
//The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
//
//Example 1:
//Input: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//Output: "1(2(4))(3)"
//
//Explanation: Originallay it needs to be "1(2(4)())(3()())", 
//but you need to omit all the unnecessary empty parenthesis pairs. 
//And it will be "1(2(4))(3)".
//Example 2:
//Input: Binary tree: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//Output: "1(2()(4))(3)"
//
//Explanation: Almost the same as the first example, 
//except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input a
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructStringfromBinaryTree {
	StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        helper(t);
        return sb.toString();
    }
    public void helper(TreeNode root){
        if (root==null) return;
        sb.append(root.val);
        if (root.left!=null){
            sb.append("(");
            helper(root.left);
            sb.append(")");
        }
        if (root.right!=null){
            if (root.left==null){
                sb.append("()");
            }
            sb.append("(");
            helper(root.right);
            sb.append(")");
        }
    }
}
