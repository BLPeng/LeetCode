package Arrays;

import java.util.ArrayList;
import java.util.List;

//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        if (matrix.length==0) return l;
        int rowBegin=0, rowEnd=matrix.length-1, colBegin=0, colEnd=matrix[0].length-1;
        while (rowBegin<=rowEnd && colBegin<=colEnd){
            for (int i=colBegin; i<=colEnd; i++){
                l.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int j=rowBegin; j<=rowEnd; j++){
                l.add(matrix[j][colEnd]);
            }
            colEnd--;
            if (rowBegin<=rowEnd){
            for (int k=colEnd; k>=colBegin; k--){
                l.add(matrix[rowEnd][k]);
            }
            }
            rowEnd--;
            if (colBegin<=colEnd){
            for (int g=rowEnd; g>=rowBegin; g--){
                l.add(matrix[g][colBegin]);
            }
            }
            colBegin++;
        }
        return l;
    }
}
