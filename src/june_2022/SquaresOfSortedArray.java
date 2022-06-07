package june_2022;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;
        while(i <= j ) {
            if(Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[k] = nums[j] * nums[j];
                k--;
                j--;
            } else {
                res[k] = nums[i] * nums[i];
                i++;
                k--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        SquaresOfSortedArray obj = new SquaresOfSortedArray();
        System.out.println(obj.sortedSquares(nums));
    }
}
