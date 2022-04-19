package problems;

/***
 * sorted array is given in which 2 elements have exchanged their positions.
 */
public class TwoElementsPositionExchanged {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,4,5,6};
        int x = -1;
        int y = -1;
        boolean found_second_element = false;
        for(int i = 0; i< nums.length - 1 ; i++) {
            if(nums[i+1] < nums[i]) {
                y = nums[i + 1];
                if(!found_second_element) {
                    x = nums[i];
                    found_second_element = true;
                } else {
                    break;
                }
            }
        }
        System.out.println(x + "   " + y);

    }
}
