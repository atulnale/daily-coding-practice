package problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator1 {
    List<Integer> list = new ArrayList<>();
    int i;
    int size;
    public void BSTIterator(TreeNode root) {
        inorder(root);
        size = list.size();
        i = 0;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return list.get(i++);
    }

    public boolean hasNext() {
        return i < size;
    }
}
