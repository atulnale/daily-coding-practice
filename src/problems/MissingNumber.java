package problems;

/***
 * @question: https://leetcode.com/problems/missing-number/solution/
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == 0 ) {
                if(nums[i] != nums.length) nums[i] = nums[0];
                nums[0] = 0;
            }
        }
        for(int ele : nums) {
            if(Math.abs(ele) != nums.length) {
                nums[Math.abs(ele)] = -1 * Math.abs(nums[Math.abs(ele)]);
            }
        }
        for(int i = 0; i< nums.length; i++ ) {
            if( nums[i] > 0) return i;
        }
        return nums.length;
    }
    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(obj.missingNumber(nums));

    }
}
