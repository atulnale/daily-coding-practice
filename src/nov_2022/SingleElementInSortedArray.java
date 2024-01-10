package nov_2022;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        System.out.println( obj.solve(new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5))));
    }
    public int solve(ArrayList<Integer> A) {
        if(A.size() == 1) return A.get(0);
        return helper(A, 0, A.size()-1);
    }

    private int helper(ArrayList<Integer> a, int left , int right) {
        int mid = left + ( right - left) / 2;
        if(mid != 0 && mid != a.size()-1) {
            if(a.get(mid) != a.get(mid -1) && a.get(mid) != a.get(mid + 1)) {
                return a.get(mid);
            } else {
                if(a.get(mid) == a.get(mid -1)) {
                    return 0;
                } else {

                }
            }
        } else {
            if(mid == 0) {
                if(a.get(mid) != a.get(mid + 1)) {
                    return a.get(mid);
                } else {
                    return helper(a, mid + 1, right);
                }
            } else {
                if(a.get(mid) != a.get(mid) -1) {
                    return a.get(mid);
                } else {
                    return helper(a, left, mid -1);
                }
            }
        }
        return 0;
    }
}
