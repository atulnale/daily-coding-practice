package problems;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dice1000000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cases = 1;
        while(cases <= t) {
            int n = sc.nextInt();
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int i = 0; i<n; i++) {
                q.add(sc.nextInt());
            }
            long i = 1;
            while(!q.isEmpty()) {
                int ele = q.poll();
                if(ele >= i) {
                    i++;
                }
            }
            System.out.println("Case #"+cases+": "+ (i-1));
            cases++;
        }
    }
}
