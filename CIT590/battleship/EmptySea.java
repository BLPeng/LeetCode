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
public class EmptySea extends Ship{
	
	public EmptySea(){
		this.length = 1;
		for (int i=0; i<hit.length; i++){
			this.hit[i] = false;
		}
	}
	
	@Override
	public boolean shootAt(int row, int column){
		return false;
	}
	
	@Override
	public boolean isSunk(){
		return false;
	}
	
	@Override
	public String toString(){
		return "-";
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "EmptySea";
	}
}
