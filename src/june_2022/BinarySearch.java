package june_2022;

/***
 * @question: https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return helper(nums,target,0,nums.length-1);
    }

    private int helper(int[] nums, int target, int left, int right) {
        if(left>right) return -1;
        int mid = left + (right - left) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid]> target) return helper(nums,target,left,mid-1);
        return helper(nums,target,mid+1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.search(nums,target));
    }
}
