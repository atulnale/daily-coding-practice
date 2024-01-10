package graphs.disjoin_sets.nov_2022;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int countLeft = 0;
        int countRight = 0;
        TreeNode curr = root.left;
        while(curr != null) {
            countLeft++;
            curr = curr.left;
        }
        curr = root.right;
        while(curr != null) {
            countRight++;
            curr = curr.right;
        }
        if(countLeft == countRight) return (int) Math.pow(2, countLeft+1) - 1;
         return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        CreateCompleteBinaryTree createCompleteBinaryTree = new CreateCompleteBinaryTree();
        TreeNode root = createCompleteBinaryTree.createLevelOrderTree(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }
}
