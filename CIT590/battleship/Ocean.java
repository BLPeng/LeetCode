/**
 * Name: Bolu Peng
 * PennId: 16847239
 * Statement：I finished this assignment all by myself
 */
package battleship;

import java.util.Random;

/**
 * @author bolupeng
 *
 */
public class Ocean {
	
	Ship[][] ships = new Ship[10][10];
	boolean[][] isHit = new boolean[10][10]; // use to record if the position has been hit or not
	int shotsFired;
	int hitCount;
	
	public Ocean(){
		for (int i=0; i<ships.length; i++){
			for (int j=0; j<ships[0].length; j++){
				this.ships[i][j] = new EmptySea();
				isHit[i][j] = false;
			}
		}
		this.shotsFired = 0;
		this.hitCount = 0;
	}
	
	/**
	 * Place all ships randomly one by one
	 * Ships with longer length should be placed first
	 */
	public void placeAllShipsRandomly(){
		Random random = new Random();
		int countB=1;
		int countC=2;
		int countD=3;
		int countS=4;
		while ((countB+countC+countD+countS)>0){
			int row = random.nextInt(10);
			int column = random.nextInt(10);
			boolean horizontal = random.nextFloat()<=0.5;
			if (countB!=0){
				Ship battleship = new Battleship();
				if (battleship.okToPlaceShipAt(row, column, horizontal, this)){
					battleship.placeShipAt(row, column, horizontal, this);
					countB--;
				}
			}
			else if (countC!=0){
				Ship cruiser = new Cruiser();
				if (cruiser.okToPlaceShipAt(row, column, horizontal, this)){
					cruiser.placeShipAt(row, column, horizontal, this);
					countC--;
				}
			}
			else if (countD!=0){
				Ship destroyer = new Destroyer();
				if (destroyer.okToPlaceShipAt(row, column, horizontal, this)){
					destroyer.placeShipAt(row, column, horizontal, this);
					countD--;
				}
			}
			else if (countS!=0){
				Ship submarine = new Submarine();
				if (submarine.okToPlaceShipAt(row, column, horizontal, this)){
					submarine.placeShipAt(row, column, horizontal, this);
					countS--;
				}
			}
		}
	}
	
	public boolean isOccupied(int row, int column){
		return ships[row][column].getShipType().equals("EmptySea") ? false : true;
	}
	
	public boolean shootAt(int row, int column){
		isHit[row][column] = true;
		shotsFired++;
		if (this.isOccupied(row, column)){
			hitCount++;
		}
		return ships[row][column].shootAt(row, column) ? true : false;
	}
	
	public int getShotsFired(){
		return shotsFired;
	}
	
	public int getHitCount(){
		return hitCount;
	}
	
	public boolean isGameOver(){
		for (int i=0; i<ships.length; i++){
			for (int j=0; j<ships[0].length; j++){
				if (this.isOccupied(i, j)){
					if (!ships[i][j].isSunk()) {
						return false; 
					}
				}
			}
		}
		return true;
	}
	
	public Ship[][] getShipArray(){
		return ships;
	}
	
	public void print(){
		System.out.print("  ");
		for (int i=0; i<10; i++){
			System.out.print(i+" ");
		}
		System.out.println();
		for (int i=0; i<ships.length; i++){
			System.out.print(i+" ");
			for (int j=0; j<ships[0].length; j++){
				if (!isHit[i][j]){
					System.out.print("."+" ");
				}
				else{
					System.out.print(ships[i][j].toString()+" ");
				}
				//System.out.print(ships[i][j].toString()+" ");
			}
			System.out.println();
		}
	}
}
