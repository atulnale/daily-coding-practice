package problems;

import utils.ConstructTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @question: https://leetcode.com/problems/convert-bst-to-greater-tree/submissions/
 */
public class ConvertBSTtoGreaterTree {
    List<Integer> list = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        List<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i<list.size(); i++){
            int num = prefix.get(i) + list.get(i);
            prefix.add(num);
            map.put(list.get(i), i);
        }
        sum = prefix.get(prefix.size()-1);
        updateTree(prefix, sum,root,map);
        return root;
   }

    private void updateTree(List<Integer> prefix, int sum, TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return;
        root.val = sum - prefix.get(map.get(root.val));
        updateTree(prefix, sum, root.left, map);
        updateTree(prefix, sum, root.right, map);

    }

    private void inorder(TreeNode root) {
        if(root == null) return ;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,1,6,0,2,5,7,-1,-1,-1,3,-1,-1,-1,8};
        TreeNode root = ConstructTree.solve(arr);

    }
}
