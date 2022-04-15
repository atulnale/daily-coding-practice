package utils;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTree {
    public static TreeNode solve(int[] arr){
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<arr.length) {
           TreeNode temp = q.poll();
           if(arr[i] != -1){
               temp.left = new TreeNode(arr[i]);
               q.add(temp.left);
           }
           i++;
           if(i < arr.length && arr[i] != -1){
               temp.right = new TreeNode(arr[i]);
               q.add(temp.right);
           }
           i++;
        }
        return root;
    }
}
