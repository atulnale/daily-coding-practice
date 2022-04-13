package graphs.disjoin_sets;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i< n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i< edges.length; i++) {
            join(edges[i][0],edges[i][1], parent);
        }
        int count = 0;
        for(int i = 0; i< parent.length; i++ ) {
            if(parent[i] == i) count++;
        }
        return count;
    }

    private void join(int i, int j, int[] parent) {
        int parent_i = find(i,parent);
        int parent_j = find(j,parent);
        if(parent_i != parent_j) parent[parent_i]= parent_j;
    }

    private int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x],parent);
        return parent[x];
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents obj = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(obj.countComponents(n,edges));
    }
}
