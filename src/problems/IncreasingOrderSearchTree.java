package problems;

import utils.TreeNode;

/***
 * @question: https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inorder(root.right);
    }
}
