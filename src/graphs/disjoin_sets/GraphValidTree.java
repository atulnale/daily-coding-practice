package graphs.disjoin_sets;

/***
 * @question: https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3910/
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i<n; i++ ) {
            parent[i] = i;
        }
        for(int i = 0; i<edges.length; i++) {
            if(union(edges[i][0], edges[i][1], parent)) return false;
        }

        int count = 0;
        for(int i = 0; i<parent.length; i++){
            if(parent[i] == i) count++;
        }
        if(count > 1) return false;
        return true;
    }

    private boolean union(int i, int j, int[] parent) {
        int parent_i = find(i,parent);
        int parent_j = find(j,parent);
        if(parent_i == parent_j) return true;
        parent[parent_i] = parent_j;
        return false;
    }

    private int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {
        GraphValidTree obj = new GraphValidTree();
        int n = 4;
        int[][] edges = new int[][]{{0,1},{2,3}};
        System.out.println(obj.validTree(n,edges));
    }
}
