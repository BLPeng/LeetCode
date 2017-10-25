package DFS;
//Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//
//The distance between two adjacent cells is 1.
//Example 1: 
//Input:
//
//0 0 0
//0 1 0
//0 0 0
//Output:
//0 0 0
//0 1 0
//0 0 0
//Example 2: 
//Input:
//
//0 0 0
//0 1 0
//1 1 1
//Output:
//0 0 0
//0 1 0
//1 2 1
//Note:
//The number of elements of the given matrix will not exceed 10,000.
//There are at least one 0 in the given matrix.
//The cells are adjacent in only four directions: up, down, left and right.

public class Matrix {
	public int[][] updateMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j]==0) dp[i][j]=0;
                else dp[i][j]=Math.min((i-1<0?Integer.MAX_VALUE-1:dp[i-1][j]),(j-1<0?Integer.MAX_VALUE-1:dp[i][j-1]))+1;
            }
        }
        for (int i=matrix.length-1; i>=0; i--){
            for (int j=matrix[0].length-1; j>=0; j--){
                if (dp[i][j]!=0 && dp[i][j]!=1) { //不等于1的原因是，因为等于1，说明已经出现最小距离
                    dp[i][j]=Math.min((i+1>=matrix.length?Integer.MAX_VALUE-1:dp[i+1][j]),(j+1>=matrix[0].length?Integer.MAX_VALUE-1:dp[i][j+1]))+1;
                }
            }
        }
        return dp;
    }
}
