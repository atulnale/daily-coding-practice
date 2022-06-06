package june_2022;

/***
 * @question: https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {
    boolean isBadVersion(int version){
        if(version < 4) return false;
        return true;
    }
    public int firstBadVersion(int n) {
        return helper(1,n,n);
    }

    private int helper(int low, int high, int curr) {
        if(low > high) return curr;
        int mid = low + (high - low) / 2;
        boolean result = isBadVersion(mid);
        if(result) return helper(low, mid -1, mid);
        return helper(mid + 1, high, curr);
    }

    public static void main(String[] args) {
        FirstBadVersion obj = new FirstBadVersion();
        System.out.println(obj.firstBadVersion(5));
    }
}
