package graphs.disjoin_sets.nov_2022;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateCompleteBinaryTree {
    public TreeNode createLevelOrderTree(List<Integer> list) {
        if(list == null || list.size() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(0));
        TreeNode curr = root;
        queue.add(root);
        for(int i = 1; i< list.size(); i++) {
            curr = queue.poll();
            curr.left = new TreeNode(list.get(i));
            i++;
            if(i < list.size()) curr.right = new TreeNode(list.get(i));
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return root;
    }

}
