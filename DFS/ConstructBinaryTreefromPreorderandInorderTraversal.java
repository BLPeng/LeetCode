package DFS;
//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright){
        if (pleft>pright || ileft>iright) return null;
        int i=0;
        for (i=ileft; i<=iright; i++){ //不一定在最中间！！！
            if (preorder[pleft]==inorder[i]) break;
        }
        TreeNode root = new TreeNode(inorder[i]);
        root.left = helper(preorder, inorder, pleft+1, pleft+(i-ileft), ileft, i-1);
        root.right = helper(preorder, inorder, pleft+(i-ileft)+1, pright, i+1, iright);
        return root;
    }
}
