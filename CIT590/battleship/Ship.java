/**
 * Name: Bolu Peng
 * PennId: 16847239
 * Statement：I finished this assignment all by myself
 */
package battleship;

/**
 * @author bolupeng
 *
 */
public abstract class Ship {
	
	int bowRow;
	int bowColumn;
	int length;
	boolean horizontal;
	boolean[] hit = new boolean[4];
	
	public abstract int getLength();
	
	public int getBowRow(){
		return bowRow;
	}
	
	public int getBowColumn(){
		return bowColumn;
	}
	
	public boolean isHorizontal(){
		return horizontal;
	}
	
	public void setBowRow(int row){
		this.bowRow = row;
	}
	
	public void setBowColumn(int column){
		this.bowColumn = column;
	}
	
	public void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}
	
	public abstract String getShipType();
	
	/**
	 * Check the possibility of placing ship at location "row,column" with direction "horizontal" at "ocean"
	 * The constraints are:
	 * 1: The four edges of any ship should not exceed the edges of ocean
	 * 2: Any two ship should not overlap with or be adjacent to each other 
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		if (row<0 || row>9 || column<0 || column>9){
			return false;
		}
		if (horizontal){
			if (column+length-1>9){
				return false;
			}
			else{
				for (int i=column; i<column+length; i++){
					if (ocean.isOccupied(row, i)) return false;
				}
				for (int i=column-1; i<column+length+1; i++){
					for (int j=row-1; j<row+2; j++){
						if (i>=column && i<column+length && j==row) continue;
						else{
							if (i<0 || j<0 || i>9 || j>9) continue;
							if (ocean.isOccupied(j, i)){
								return false;
							}
						}
					}
				}
				return true;
			}
		}
		else{
			if (row+length-1>9){
				return false;
			}
			else{
				for (int i=row; i<row+length; i++){
					if (ocean.isOccupied(i, column)) return false;
				}
				for (int i=column-1; i<column+2; i++){
					for (int j=row-1; j<row+length+1; j++){
						if (i==column && j>=row && j<row+length) continue;
						else{
							if (i<0 || j<0 || i>9 || j>9) continue;
							if (ocean.isOccupied(j, i)){
								return false;
							}
						}
					}
				}
				return true;
			}
		}
	}
	
	/**
	 * Set the location of bowRow and bowColumn
	 * Place ship at location "row,column" with direction "horizontal" at "ocean"
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		if (horizontal){
			for (int i=column; i<column+length; i++){
				ocean.getShipArray()[row][i] = this;
			}
		}
		else{
			for (int i=row; i<row+length; i++){
				ocean.getShipArray()[i][column] = this;
			}
		}
	}
	
	//update the hit array
	public boolean shootAt(int row, int column){
		if (!this.isSunk()){
			if (this.getShipType().equals("EmptySea")){
				return false;
			}
			else{
				if (isHorizontal()){
					hit[column-getBowColumn()] = true;
				}
				else{
					hit[row-getBowRow()] = true;
				}
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean isSunk(){
		for (int i=0; i<length; i++){
			if (!hit[i]) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString(){
		return this.isSunk() ? "x" : "S";
	}
	
}
