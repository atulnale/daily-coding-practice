package problems;

import utils.TreeNode;

public class SearchInBinarySearchTree {
    public static void main(String[] args) {
        SearchInBinarySearchTree obj = new SearchInBinarySearchTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(obj.searchBST(root,2));
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val == root.val) {
            return root;
        } else if( val < root.val) {return searchBST(root.left,val);}
        else {
            return searchBST(root.right,val);
        }
    }
}
