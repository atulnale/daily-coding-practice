package problems;

import utils.ConstructTree;
import utils.TreeLevelOrderTraversal;
import utils.TreeNode;

/***
 * @question: https://leetcode.com/problems/trim-a-binary-search-tree/submissions/
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null ) return root;
        if(root.val < low) return trimBST(root.right,low,high);
        if(root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = ConstructTree.solve(new int[]{3,0,4,-1,2,-1,-1,1});
        TrimABinarySearchTree obj = new TrimABinarySearchTree();

        TreeNode res = obj.trimBST(root,1,3);

        TreeLevelOrderTraversal.printLevelOrder(res);

    }
}
