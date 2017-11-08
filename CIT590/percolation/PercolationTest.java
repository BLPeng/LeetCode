/*
 * Name: Bolu Peng
 * PennID: 16847239
 * Statement: I accomplish this assignment all by myself
 */
package percolation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PercolationTest {

	@Test
	public void testGround() {
		Percolation sample = new Percolation();
		int count = 50, times = 0;
		while (count>0){
			int[][] board = sample.ground(50,0.5);
			for (int i=0; i<board.length; i++){
				for (int j=0; j<board[0].length; j++){
					if (board[i][j]==1){
						times ++;
					}
				}
			}
		}
		double result = (times*50)/(50*50);
		assertTrue(Math.abs(result-0.5)<0.01);
	}
	
	@Test
	public void testSeep(){
		Percolation sample = new Percolation();
		int[][] board = {{1,2,1,2,1},
						 {0,0,0,1,0},
						 {1,0,1,1,0},
						 {1,0,0,0,0},
						 {1,0,1,1,0}};
		sample.seep(board, 0);
		assertTrue(java.util.Arrays.equals(board[1], new int[]{2,2,2,1,0}));
		sample.seep(board, 1);
		assertTrue(java.util.Arrays.equals(board[2], new int[]{1,2,1,1,0}));
		sample.seep(board, 2);
		assertTrue(java.util.Arrays.equals(board[3], new int[]{1,2,2,2,2}));
		sample.seep(board, 3);
		assertTrue(java.util.Arrays.equals(board[4], new int[]{1,2,1,1,2}));
	}
	
	@Test
	public void testPercolate(){
		Percolation sample = new Percolation();
		int[][] board = {{1,2,1,2,1},
				 		 {0,0,0,1,0},
				 		 {1,0,1,1,0},
				 		 {1,0,0,0,0},
				 		 {1,0,1,1,0}};	
		for (int i=0; i<board.length-1; i++){
			sample.seep(board, i);
		}
		assertTrue(sample.percolate(board));
		int[][] board1 = {{1,2,1,2,1},
		 		 		  {0,0,0,1,0},
		 		 		  {1,0,1,1,0},
		 		 		  {1,0,0,0,0},
		 		 		  {1,1,1,1,1}};	
		for (int i=0; i<board1.length-1; i++){
			sample.seep(board1, i);
		}
		assertFalse(sample.percolate(board1));
	}
}
