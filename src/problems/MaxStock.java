package problems;

public class MaxStock {
    public static void main(String[] args) {
        int[] nums = new int[]{700, 900, 500, 600, 300, 200};
        int ans = -1;
        int i =0;
        int j = i + 1;
        int curr = -1;
        while(j < nums.length){
            if(nums[j] < nums[i] && nums[j] < nums[j-1]){
                i = j;
            } else {
                curr = nums[j] - nums[i];
            }
            ans = Math.max(ans, curr);
            j++;
        }
        System.out.println(ans);
    }
}
