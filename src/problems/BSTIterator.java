package problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***
 * @question: https://leetcode.com/problems/binary-search-tree-iterator-ii/submissions/
 */
public class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int i ;
    public BSTIterator(TreeNode root) {
        inorder(root);
        i = -1;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public boolean hasNext() {
        if(i<list.size()-1) {
            return true;
        }
        return false;
    }

    public int next() {

        return list.get(++i);
    }

    public boolean hasPrev() {
        if(i <= 0) return false;
        return true;
    }

    public int prev() {
        return list.get(--i);
    }
}
