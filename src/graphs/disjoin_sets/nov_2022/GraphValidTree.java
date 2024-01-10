package graphs.disjoin_sets.nov_2022;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i< n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i<edges.length; i++) {
            boolean result = union(edges[i][0], edges[i][1],parent);
            if(!result){
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i]==i) count++;
        }
        if(count>1) return false;
        return true;
    }
    public int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[parent[x]],parent);
        return parent[x];
    }
    public boolean union(int x, int y, int[] parent) {
        int xParent = find(x,parent);
        int yParent = find(y, parent);
        if(xParent == yParent) return false;
        parent[xParent] = yParent;
        return true;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        int n = 5;
        GraphValidTree obj = new GraphValidTree();
        System.out.println(obj.validTree(n,edges));
    }
}
