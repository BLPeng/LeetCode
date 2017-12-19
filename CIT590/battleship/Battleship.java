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
public class Battleship extends Ship{
	
	public Battleship(){
		this.length = 4;
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
		return "Battleship";
	}
	
	public static void main(String[] args){
		int b=0;
		Ship a = new Battleship();
		System.out.println(a.getShipType());
		return;
		System.out.println(b);
	}
	
}