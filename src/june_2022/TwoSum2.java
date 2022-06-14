package june_2022;

/***
 * @question: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length -1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[]{i+1, j+ 1};
            if(sum < target) i++;
            else j--;
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum2 obj = new TwoSum2();
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        int[] result = obj.twoSum(numbers, target);
        for(int i = 0; i< result.length; i++){
            System.out.print("  " + result[i]);
        }
    }
}
