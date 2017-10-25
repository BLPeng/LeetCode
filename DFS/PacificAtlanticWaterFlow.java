package DFS;

import java.util.ArrayList;
import java.util.List;

//Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
//Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//
//Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
//
//Note:
//The order of returned grid coordinates does not matter.
//Both m and n are less than 150.
//Example:
//
//Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
//Return:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> l = new ArrayList<int[]>();
        if (matrix.length==0 || matrix[0].length==0) return l;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            helper(matrix, pacific, Integer.MIN_VALUE, i, 0);
            helper(matrix, atlantic, Integer.MIN_VALUE, i, matrix[0].length-1);
        }
        for (int i=0; i<matrix[0].length; i++){
            helper(matrix, pacific, Integer.MIN_VALUE, 0, i);
            helper(matrix, atlantic, Integer.MIN_VALUE, matrix.length-1, i);
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (pacific[i][j] && atlantic[i][j]) l.add(new int[]{i,j});
            }
        }
        return l;
    }
    public void helper(int[][] matrix, boolean[][] visited, int maxheight, int i, int j){
        if (i<0 || i>matrix.length-1 || j<0 || j>matrix[0].length-1 || visited[i][j]==true || matrix[i][j]<maxheight) return;
        visited[i][j]=true;
        helper(matrix, visited, matrix[i][j], i+1, j);
        helper(matrix, visited, matrix[i][j], i-1, j);
        helper(matrix, visited, matrix[i][j], i, j+1);
        helper(matrix, visited, matrix[i][j], i, j-1);
    }
}
