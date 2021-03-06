package march_31_2022;

import utils.TreeNode;
/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedIntArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left, int right) {
        if(left > right) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left,mid -1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
