package june_2022;

/***
 * @question: https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == 0) {
                break;
            }
            i++;
        }
        if(i == nums.length) return;
        int j = i;
        while( j< nums.length) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
                nums[j]=0;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};
        obj.moveZeroes(nums);
        for(int i = 0; i< nums.length; i++){
            System.out.print("  " +nums[i]);
        }
    }
}
