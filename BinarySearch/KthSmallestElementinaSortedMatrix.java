package BinarySearch;
//Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//Example:
//
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//return 13.
public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        int start=matrix[0][0], end=matrix[matrix.length-1][matrix[0].length-1];
        while (start<end){
            int mid = (start+end)/2;
            int count=0, j=matrix[0].length-1;
            for (int i=0; i<matrix.length; i++){
                while (j>=0 && matrix[i][j]>mid) j--;
                count += (j+1);
            }
            if (count<k) start = mid+1;
            else end = mid;
        }
        return end;
    }
}
