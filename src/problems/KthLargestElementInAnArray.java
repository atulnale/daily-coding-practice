package problems;

import java.util.PriorityQueue;

/***
 * @question: https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int ele: nums) {
            q.add(ele);
            if(q.size()>k) q.poll();
        }
        return q.peek();
    }
    public static void main(String[] args) {

        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();


        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(obj.findKthLargest(arr,k));

    }
}
