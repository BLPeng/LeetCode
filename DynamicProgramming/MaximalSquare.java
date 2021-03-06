package lc;
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

//For example, given the following matrix:

//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0

//Return 4.

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (i==0 || j==0) dp[i][j]= matrix[i][j]=='1'?1:0;
                else if (i>0 && j>0 && matrix[i][j]=='1') {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        return (int)Math.pow(result,2);
    }
}
