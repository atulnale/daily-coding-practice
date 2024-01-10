package graphs.disjoin_sets;

/***
 * @question: https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3845/
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];
        for(int i = 0; i< parent.length; i++) {
            parent[i] = i;
        }
        for(int i = 0; i< isConnected.length; i++) {
            for(int j = 0; j< isConnected[0].length; j++) {
                if(i != j && isConnected[i][j] == 1){
                    union(i,j,parent);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i< parent.length; i++) {
            if(parent[i] == i) ans++;
        }
        return ans;

    }
    public int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public void union(int x, int y, int[] parent) {
        int xParent = find(x,parent);
        int yParent = find(y,parent);
        if(xParent == yParent) return;
        parent[xParent] = yParent;
    }
    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();
        int[][] isConnected = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(obj.findCircleNum(isConnected));
    }
}
