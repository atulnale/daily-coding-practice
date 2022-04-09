package problems;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class ArrayCloningTechnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            //if(n == 1) System.out.println(0);
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< arr.length; i++) {
                if(map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i],1);
                }
            }
            int max = map.values().stream().max(Integer::compareTo).get();
            int ans = 0;
            while(n != max){
                ans++;
                if(n < max+max){
                    ans += n - max;
                    break;
                } else {
                    ans += max;
                    max = max + max;
                }

            }
            System.out.println(ans);
            t--;
        }
    }
}
