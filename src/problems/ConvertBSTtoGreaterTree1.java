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
public class ConvertBSTtoGreaterTree1 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
       if(root != null) {
           convertBST(root.right);
           sum += root.val;
           root.val = sum;
           convertBST(root.left);
       }
       return root;
   }

    public static void main(String[] args) {
        int[] arr = new int[] {4,1,6,0,2,5,7,-1,-1,-1,3,-1,-1,-1,8};
        TreeNode root = ConstructTree.solve(arr);

    }
}
