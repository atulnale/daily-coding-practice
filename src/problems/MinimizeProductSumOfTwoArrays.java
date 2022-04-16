package problems;

import java.util.PriorityQueue;

/***
 * @question: https://leetcode.com/problems/minimize-product-sum-of-two-arrays/
 */
public class MinimizeProductSumOfTwoArrays {
    public int minProductSum(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i<nums1.length; i++) {
            min.add(nums1[i]);
            max.add(nums2[i]);
        }
        int ans = 0;
        while(!min.isEmpty()){
            ans += min.poll() * max.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] num1 = new int[]{2,1,4,5,7};
        int[] num2 = new int[]{3,2,4,8,6};
        MinimizeProductSumOfTwoArrays obj = new MinimizeProductSumOfTwoArrays();
        System.out.println(obj.minProductSum(num1,num2));

    }
}
