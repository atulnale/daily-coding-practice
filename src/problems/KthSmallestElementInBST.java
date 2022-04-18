package problems;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list.get(k-1);
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public static void main(String[] args) {

    }
}
