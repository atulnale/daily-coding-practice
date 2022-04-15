package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTraversal {
    public static void printLevelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            System.out.print(temp.val+" ");
            if(temp.left != null ) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
    }
}
