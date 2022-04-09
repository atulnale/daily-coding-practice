package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/***
 * @question: https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */
public class TopKFrequentElements {
    class Value {
        int key;
        int value;
        Value(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public int[] topKFrequent(int[] nums, int k ) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele) + 1);
            } else {
                map.put(ele, 1);
            }
        }
        PriorityQueue<Value> q = new PriorityQueue<>((a,b) -> a.value - b.value);
        for(int ele: map.keySet()){
            q.add(new Value(ele, map.get(ele)));
            if(q.size() > k) q.poll();
        }
        int[] res = new int[k];
        int i = 0;
        while(!q.isEmpty()) {
            res[i] = q.poll().key;
            i++;
        }
        return res;

    }
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = new int[] {1,1,1,2,2,2,3,3,3,3,3,3};
        int k = 2;
        int[] res = obj.topKFrequent(nums, k);
        for(int ele : res) {
            System.out.print(ele+ "  ");
        }
    }
}
