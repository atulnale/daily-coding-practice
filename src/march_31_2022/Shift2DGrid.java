package march_31_2022;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @question: https://leetcode.com/problems/shift-2d-grid/
 *
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * Example 2:
 *
 *
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * Example 3:
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        k = k % (r * c);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< r; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<c ; j++ ) {
                temp.add(0);
            }
            result.add(temp);
        }
        int _j = k%c;
        int _i = k/c;
        for(int i  = 0; i< r; i++) {
            for(int j = 0; j<c; j++) {
                result.get(_i).set(_j,grid[i][j]);
                _j++;
                if(_j == c){
                    _j = 0;
                    _i++;
                }
                if(_i==r){
                    _i = 0;
                }
            }
        }
        return result;

    }
    public static void main(String[] args) {
        Shift2DGrid obj = new Shift2DGrid();
        int[][] grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(obj.shiftGrid(grid,9));
    }
}
