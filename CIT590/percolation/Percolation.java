/*
 * Name: Bolu Peng
 * PennID: 16847239
 * Statement: I accomplish this assignment all by myself
 */
package percolation;

public class Percolation {
	/* 
	 * create a new array with every integer has a probability p to be 1
	 * the position of 1 is randomly generated
	 */
	public int[][] ground(int n, double p){
		int[][] result = new int[n][n];
		for (int i=0; i<result.length; i++){
			for (int j=0; j<result[0].length; j++){
				result[i][j] = Math.random()<=p ? 1 : 0;
			}
		}
		return result;
	}
	/* 
	 * Seep the ground one layer by one layer
	 * vertically and horizontally
	 */
	public void seep(int[][] ground, int row){
		for (int i=0; i<ground[0].length; i++){
			ground[row+1][i] = (ground[row][i]==2 && ground[row+1][i]==0) ? 2 : ground[row+1][i];
		}
		for (int i=0; i<ground[0].length; i++){
			if (ground[row+1][i]==2){
				int left = i-1, right = i+1;
				while (left>=0 && ground[row+1][left]==0){
					ground[row+1][left--] = 2;
				}
				while (right<ground[0].length && ground[row+1][right]==0){
					ground[row+1][right++] = 2;
				}
			}
		}
	}
	/* 
	 * Check if water percolate the ground
	 * if the last layer contains 2, then return true
	 */
	public boolean percolate(int[][] ground){
		for (int i=0; i<ground[ground.length-1].length; i++){
			if (ground[ground.length-1][i]==2){
				return true;
			}
		}
		return false;
	}
	/* 
	 * find the probability of p that will lead to a 0.5 probability of
	 * permission.
	 */
	public double findProbability(int n){
		double[] trialBefore = new double[2];
		double[] trialAfter = new double[2];
		double p = 0.5, times = 0, delta = 0.05, difference = 1;
		
		while (difference>0.03){
			int countOne = 1;
			while (countOne>=0){
				double runTime = 30;
				while (runTime>0){
					int[][] board = ground(n,p);
					for (int i=0; i<board[0].length; i++){
						board[0][i] = board[0][i]==0 ? 2 : board[0][i];
					}
					for (int i=0; i<board.length-1; i++){
						seep(board,i);
					}
					if (percolate(board)){
						times++;
					}
					runTime--;
				}
				trialBefore[countOne] = trialAfter[countOne];
				trialAfter[countOne--] = (double)times/(double)30;	
			}
			
			double sumBefore = trialBefore[1] + trialBefore[1];
			double sumAfter = trialAfter[0] + trialAfter[1];
			
			if (sumBefore!=0 && Math.abs(Math.abs(sumBefore-1.5) - Math.abs(sumAfter-1.5))<difference){
				delta *= 0.8;
				difference *= 0.89;
			}
			
			if (((double)sumAfter/(double)2)<0.5){
				p -= delta;
			}
			else if (((double)sumAfter/(double)2)>0.5){
				p += delta;
			}
			times = 0;
		}
		return p;
	}
	
    public static void main(String args[]){
    	//The main function
    	Percolation wet = new Percolation();
    	int[] sample = {50,100,200};
    	for (int i=0; i<sample.length; i++){
    		System.out.printf("\n the possibility for size %d is %3.2f",sample[i],wet.findProbability(sample[i]));
    	}
    }
}
