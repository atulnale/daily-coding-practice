package problems;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i<nums.length - 2; i++){
            int key = target - nums[i];
            int left = i + 1;
            int right = nums.length -1;
            while(left<right)  {
                if(Math.abs(nums[i]+nums[left]+nums[right] - target) < ans ) {
                    ans = Math.abs(nums[i]+nums[left]+nums[right] - target);
                    result = nums[i]+nums[left]+nums[right];
                }
                if(nums[left] + nums[right] < key) {
                    left++;
                } else if(nums[left] + nums[right] > key) {
                    right --;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,0};
        int target = 1;
        ThreeSumClosest obj = new ThreeSumClosest();
        System.out.println(obj.threeSumClosest(nums,target));
    }
}
