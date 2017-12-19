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
public class Destroyer extends Ship{
	
	public Destroyer(){
		this.length = 2;
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
		return "Destroyer";
	}
	
}
