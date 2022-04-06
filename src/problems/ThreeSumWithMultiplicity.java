package problems;

import java.util.*;

/***
 * @question: https://leetcode.com/problems/3sum-with-multiplicity/submissions/
 */
public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
       Arrays.sort(arr);
       int mod = 1000000007;
       long ans = 0;
       for(int i = 0; i<arr.length; i++) {
           int key = target - arr[i];
           int left = i + 1;
           int right = arr.length - 1;
           while(left < right) {
               if(arr[left] + arr[right] > key) {
                   right--;
               } else if(arr[left] + arr[right] < key ) {
                   left++;
               } else if(arr[left] == arr[right]) {
                   int count = right - left + 1;
                    ans += ((long)count * (count -1))/2;
                    ans = ans % mod;
                    break;
               } else {
                   int count1 = 0;
                   int count2 = 0;
                   int m = left;
                   int n = right;
                   while(m<n){
                       if(arr[m] == arr[left]){
                           count1++;
                           m++;
                       } else {
                           break;
                       }
                   }
                   while(m<=n){
                       if(arr[n] == arr[right]){
                           count2++;
                           n--;
                       } else {
                           break;
                       }
                   }
                    ans += ((long)count1 * count2) % mod;
                   ans = ans % mod;
                   left = m;
                   right = n;
               }
           }
       }
       return (int)(ans % mod);
    }
    public static void main(String[] args) {
        ThreeSumWithMultiplicity obj = new ThreeSumWithMultiplicity();
        int[] arr = new int[]{1,1,2,2,3,3,4,4,5,5};
        System.out.println(obj.threeSumMulti(arr,8));
    }
}
/***
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 * Example 2:
 *
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 */