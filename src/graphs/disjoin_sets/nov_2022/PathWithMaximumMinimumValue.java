package graphs.disjoin_sets.nov_2022;

public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] grid) {
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                int top = 0;
                int left = 0;
                if(i != 0) {
                    top = grid[i-1][j];
                }
                if(j != 0){
                    left = grid[i][j-1];
                }
                grid[i][j] = Math.max(top,left) + grid[i][j];
            }
        }
        int i = grid.length-1;
        int j = grid[0].length-1;
        int ans = grid[0][0];
        while(i >0 || j> 0) {
            if(i==0){
                ans = Math.min(ans, grid[i][j] - grid[i][j-1]);
                j--;
            } else if(j == 0){
                ans = Math.min(ans, grid[i][j] - grid[i-1][j]);
                i--;
            } else{
                if(grid[i-1][j] > grid[i][j-1]) {
                    ans = Math.min(ans, grid[i][j] - grid[i-1][j]);
                    i--;
                } else {
                    ans = Math.min(ans, grid[i][j] - grid[i][j-1]);
                    j--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        PathWithMaximumMinimumValue obj= new PathWithMaximumMinimumValue();
        int[][] grid = {{2,2,1,2,2,2},{1,2,2,2,1,2}};
        System.out.println(obj.maximumMinimumPath(grid));
    }
}
