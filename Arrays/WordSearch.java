package Arrays;
//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if ((word.charAt(0)==board[i][j]) && helper(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int i, int j, String word, int index, boolean[][] visited){
        if (index==word.length()) return true;
        if (i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || word.charAt(index)!=board[i][j] || visited[i][j]==true) return false;
        visited[i][j]=true;
        if (helper(board, i+1, j, word, index+1, visited) || helper(board, i-1, j, word, index+1, visited) || helper(board, i, j+1, word, index+1, visited) || helper(board, i, j-1, word, index+1, visited)) return true;
        visited[i][j]=false;
        return false;
    }
}
