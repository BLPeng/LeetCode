package Arrays;
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int target=1;
        int rowBegin=0, rowEnd=n-1, colBegin=0, colEnd=n-1;
        while (rowBegin<=rowEnd && colBegin<=colEnd){
            for (int i=colBegin; i<=colEnd; i++){
                result[rowBegin][i]=target;
                target++;
            }
            rowBegin++;
            for (int i=rowBegin; i<=rowEnd; i++){
                result[i][colEnd]=target;
                target++;
            }
            colEnd--;
            if (colBegin<=colEnd){
                for (int i=colEnd; i>=colBegin; i--){
                    result[rowEnd][i]=target;
                    target++;
                }
            }
            rowEnd--;
            if (rowBegin<=rowEnd){
                for (int i=rowEnd; i>=rowBegin; i--){
                    result[i][colBegin]=target;
                    target++;
                }
            }
            colBegin++;
        }
        return result;
    }
}
