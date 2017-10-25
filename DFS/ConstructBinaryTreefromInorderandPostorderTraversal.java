package DFS;
//Given inorder and postorder traversal of a tree, construct the binary tree.
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
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int ileft, int iright, int pleft, int pright){
        if (ileft>iright || pleft>pright) return null;
        int i=0;
        for (i=ileft; i<=iright; i++){
            if (inorder[i]==postorder[pright]) break;
        }
        TreeNode root = new TreeNode(inorder[i]);
        root.left = helper(inorder, postorder, ileft, i-1, pleft, pleft+i-ileft-1);
        root.right = helper(inorder, postorder, i+1, iright, pleft+i-ileft, pright-1);
        return root;
    }
}
