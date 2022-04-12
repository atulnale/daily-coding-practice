package graphs.disjoin_sets;

/***
 * @question: https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3845/
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for(int i = 0; i<parent.length; i++) {
            parent[i] = i;
        }
        for(int i = 0; i<isConnected.length; i++) {
            for(int j = 0; j<isConnected[0].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    union(i,j, parent);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<parent.length; i++){
            if(parent[i] == i) ans++;
        }
        return ans;
    }

    private void union(int i, int j, int[] parent) {
        int parent_i = find(i,parent);
        int parent_j = find(j, parent);
        if(parent_i != parent_j) parent[parent_i] = parent_j;
    }

    private int find(int i, int[] parent) {
        if(i == parent[i]) return i;
        parent[i] = parent[find(parent[i],parent)];
        return parent[i];
    }

    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();
        int[][] isConnected = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(obj.findCircleNum(isConnected));
    }
}
