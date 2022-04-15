package graphs.disjoin_sets;

import java.util.Arrays;
import java.util.Comparator;

/***
 * @question: https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3912/
 */
public class EveryoneBecomesFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                Integer a = o1[0];
                Integer b = o2[0];
                return a.compareTo(b);
            }
        });
        int[] parent = new int[n];
        for(int i = 0; i< parent.length; i++) parent[i] = i;
        int maxtime =Integer.MIN_VALUE;
        for(int[] log : logs){
            maxtime = union(log,parent, maxtime);
        }
        int count = 0;
        for(int i = 0; i< parent.length; i++) {
            if(parent[i] == i) count++;
        }
        if(count>1) return -1;
        return maxtime;
    }

    private int union(int[] log, int[] parent, int maxtime) {
        int parent_i = find(log[1],parent);
        int parent_j = find(log[2],parent);
        if(parent_i != parent_j){
            parent[parent_i] = parent_j;
            maxtime = log[0];
        }
        return maxtime;
    }

    private int find(int i, int[] parent) {
        if(i == parent[i]) return i;
        parent[i]= find(parent[i],parent);
        return parent[i];
    }

    public static void main(String[] args) {
        int[][] logs = new int[][]{{20190101,0,1},{20190104,3,4},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int n = 6;
        EveryoneBecomesFriends obj = new EveryoneBecomesFriends();
        System.out.println(obj.earliestAcq(logs,n));
    }
}
