package problems;

/***
 * @question: https://leetcode.com/problems/game-of-life/
 *
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[0].length;j++) {
                if(board[i][j] == 0 ){
                    int count0 = 0;
                    for(int r = i-1; r<=i+1; r++){
                        for(int c = j-1; c <= j+1; c++){
                            if(r>=0 && r < board.length && c >= 0 && c<board[0].length && !(r== i && c == j) && board[r][c] >= 1){
                                count0++;
                            }
                        }
                    }
                    if(count0 ==3){
                        board[i][j] = -1;
                    }
                } else {
                    int count1 = 0;
                    for(int r = i-1; r<=i+1; r++){
                        for(int c = j-1; c <= j+1; c++){
                            if(r>=0 && r < board.length && c >= 0 && c<board[0].length && !(r== i && c == j) && board[r][c] >= 1){
                                count1++;
                            }
                        }
                    }
                    if(count1 < 2 || count1 >3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(board[i][j] == 2){
                    board[i][j] = 0;
                } else if(board[i][j] == -1){
                    board[i][j] = 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] board = new int[][]{{1,1},{1,0}};
        obj.gameOfLife(board);
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                System.out.print(board[i][j]+ "  ");
            }
            System.out.println();
        }
    }
}
