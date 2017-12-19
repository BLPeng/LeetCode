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
public class Cruiser extends Ship{
	
	public Cruiser(){
		this.length = 3;
		for (int i=0; i<hit.length; i++){
			this.hit[i] = false;
		}
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public String getShipType() {
		return "Cruiser";
	}
	
}
