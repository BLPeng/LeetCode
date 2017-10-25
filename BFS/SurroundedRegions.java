package BFS;
//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X

public class SurroundedRegions {
	public void solve(char[][] board) {
        if (board.length==0 || board[0].length==0) return;
        for (int i=0; i<board.length; i++){
            if (board[i][0]=='O' || board[i][board[0].length-1]=='O'){
                helper(board, i, 0);
                helper(board, i, board[0].length-1);
            }
        }
        for (int i=0; i<board[0].length; i++){
            if (board[0][i]=='O' || board[board.length-1][i]=='O'){
                helper(board, 0, i);
                helper(board, board.length-1, i);
            }
        }
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='1') continue;
                else board[i][j]='X';
            }
        }
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='1') board[i][j]='O';
                else continue;
            }
        }
    }
    public void helper(char[][] board, int i, int j){
        if (i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || board[i][j]=='1' || board[i][j]=='X') return;
        if (board[i][j] == 'O')
		board[i][j] = '1';
	if (i > 1 && board[i-1][j] == 'O') //需要判断位置上是否为O，否则容易溢出
		helper(board, i-1, j);
	if (i < board.length - 2 && board[i+1][j] == 'O')
		helper(board, i+1, j);
	if (j > 1 && board[i][j-1] == 'O')
		helper(board, i, j-1);
	if (j < board[i].length - 2 && board[i][j+1] == 'O' )
		helper(board, i, j+1);
    }
}
