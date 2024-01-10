package sept_21_2022;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length > 1) {
            nums[1] =  Math.max(nums[0],nums[1]);
        }
        for(int i = 2; i< nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] nums = new int[]{2,1,1,2};
        System.out.println(obj.rob(nums));
    }
}
