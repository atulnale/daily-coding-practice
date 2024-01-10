package graphs.disjoin_sets.nov_2022;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public void union(int x, int y, int[] parent) {
        int X = find(x,parent);
        int Y = find(y, parent);
        if(X != Y) parent[X] = Y;
    }
    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[20005];
        int[] parent = new int[20005];
        for(int i = 0; i< parent.length ; i++) {
            parent[i] = i;
        }
        for(int[] stone: stones) {
            int x = stone[0];
            int y = stone[1] + 10001;
            visited[x] = true;
            visited[y] = true;
            union(x,y, parent);
        }
        int count = 0;
        for(int i = 0; i< visited.length; i++) {
            if(visited[i] && (parent[i]==i)) {
                count++;
            }
        }
        return stones.length - count;

    }
    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn obj = new MostStonesRemovedWithSameRowOrColumn();
        int[][] stones = {{0,1},{1,0},{1,1}};
        //{0,0},{0,2},{1,1},{2,0},{2,2}
        //{0,1},{1,0},{1,1}
        System.out.println(obj.removeStones(stones));
    }
}
