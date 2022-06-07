package june_2022;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1]) return nums.length;
        return helper(nums, target, 0, nums.length-1, nums.length-1);
    }

    private int helper(int[] nums, int target, int left, int right, int curr) {
        if(left > right) return curr;
        int mid = left + (right - left ) /2;
        if(nums[mid] == target) return mid;
        else if(nums[mid]> target) return helper(nums, target, left, mid -1, mid);
        else {
            return helper(nums, target, mid + 1, right, curr);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        SearchInsertPosition obj = new SearchInsertPosition();
        System.out.println(obj.searchInsert(nums,target));
    }
}
