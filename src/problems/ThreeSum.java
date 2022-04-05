package problems;

import java.util.*;

/***
 * @question: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2966/
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> hm = new HashMap<>();
        Set<String> seen = new HashSet<>();
        for(int i =0; i< nums.length; i++) {
            hm.put(nums[i],i);

        }
        for(int i = 0; i< nums.length -2; i++) {
            for(int j = i+1; j<nums.length -1; j++) {
                int sum = nums[i] + nums[j];
                if(seen.contains(sum)) continue;
                if(hm.containsKey((-1)*sum)) {
                    if(!seen.contains(nums[i]+":"+nums[j]+":"+((-1) * sum)) && hm.get((-1) * sum) > j) {
                        seen.add(nums[i]+":"+nums[j]+":"+((-1) * sum));
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],(-1)*sum)));
                    }
                }

            }
        }
        return res;

    }
}


/***
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */