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
public class Submarine extends Ship{
	
	public Submarine(){
		this.length = 1;
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
		return "Submarine";
	}
	
}
