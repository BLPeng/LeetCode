/**
 * Name: Bolu Peng
 * PennId: 16847239
 * Statement：I finished this assignment all by myself
 */
package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author bolupeng
 *
 */
public class OceanTest {
	
	Ship battleShip;
	Ship cruiser;
	Ship destroyer;
	Ship submarine;
	Ship emptySea;
	Ocean ocean;
	
	public void setUp(){
		battleShip = new Battleship();
		cruiser = new Cruiser();
		destroyer = new Destroyer();
		submarine = new Submarine();
		emptySea = new EmptySea();
		ocean = new Ocean();
	}

	@Test
	public void testOcean() {
		setUp();
		boolean legal = true;
		int count=50;
		int countSpots=0;
		while (count>0){
			for (int i=0; i<ocean.ships.length; i++){
				for (int j=0; j<ocean.ships[0].length; j++){
					countSpots++;
					if (!ocean.ships[i][j].getShipType().equals("EmptySea")){
						legal = false;
					}
				}
			}
			assertEquals(legal,true);
			assertEquals(ocean.shotsFired, 0);
			assertEquals(ocean.hitCount, 0);
			assertEquals(countSpots, 100);
			count--;
			countSpots=0;
		}
	}

	@Test
	public void testPlaceAllShipsRandomly(){
		setUp();
		ocean.placeAllShipsRandomly();
		boolean adjacent = false;
		boolean[][] visited = new boolean[10][10];
		int count = 1000;
		int countShips = 0;
		// Run 1000 times
		while (count>0){
			for (int row=0; row<ocean.ships.length; row++){
				for (int column=0; column<ocean.ships[0].length; column++){
					if (ocean.isOccupied(row, column) && !visited[row][column]){
						countShips++;
						if (ocean.ships[row][column].isHorizontal()){
							for (int i=column-1; i<column+ocean.ships[row][column].length+1; i++){
								for (int j=row-1; j<row+2; j++){
									if (i>=column && i<column+ocean.ships[row][column].length && j==row){
										visited[j][i] = true;
									}
									else{
										if (i<0 || j<0 || i>9 || j>9) continue;
										if (ocean.isOccupied(j, i)){
											adjacent = true;
										}
									}
								}
							}
						}
						else{
							for (int i=column-1; i<column+2; i++){
								for (int j=row-1; j<row+ocean.ships[row][column].length+1; j++){
									if (i==column && j>=row && j<row+ocean.ships[row][column].length){
										visited[j][i] = true;
									}
									else{
										if (i<0 || j<0 || i>9 || j>9) continue;
										if (ocean.isOccupied(j, i)){
											adjacent = true;
										}
									}
								}
							}
						}
					}
				}
			}
			// First step, check if all ships are not adjacent
			assertEquals(adjacent,false);
			// Second step, check if there are 10 ships in total
			assertEquals(countShips, 10);
			count--;
		}
	}
	
	@Test
	public void testIsOccupied(){
		setUp();
		assertFalse(ocean.isOccupied(3, 5));
		assertFalse(ocean.isOccupied(3, 6));
		assertFalse(ocean.isOccupied(3, 7));
		assertFalse(ocean.isOccupied(3, 8));
		battleShip.placeShipAt(3, 5, true, ocean);
		assertTrue(ocean.isOccupied(3, 5));
		assertTrue(ocean.isOccupied(3, 6));
		assertTrue(ocean.isOccupied(3, 7));
		assertTrue(ocean.isOccupied(3, 8));
	}
	
	@Test
	public void testShootAt(){
		setUp();
		battleShip.placeShipAt(5, 8, false, ocean);
		assertFalse(ocean.shootAt(0, 8));
		assertFalse(ocean.shootAt(1, 5));
		assertTrue(ocean.shootAt(5, 8));
		assertTrue(ocean.shootAt(6, 8));
		assertTrue(ocean.shootAt(7, 8));
		assertTrue(ocean.shootAt(8, 8));
		assertFalse(ocean.shootAt(6, 8));
		assertFalse(ocean.shootAt(7, 8));
	}
	
	@Test
	public void testGetShotsFired(){
		setUp();
		ocean.shootAt(0, 0);
		ocean.shootAt(1, 1);
		ocean.shootAt(2, 2);
		ocean.shootAt(3, 3);
		ocean.shootAt(4, 4);
		ocean.shootAt(3, 3);
		ocean.shootAt(2, 2);
		ocean.shootAt(1, 1);
		assertEquals(ocean.getShotsFired(),8);
	}
	
	@Test
	public void testGetHitCount(){
		setUp();
		battleShip.placeShipAt(2, 3, true, ocean);
		ocean.shootAt(0, 0);
		ocean.shootAt(1, 1);
		ocean.shootAt(2, 2);
		assertEquals(ocean.getHitCount(),0);
		ocean.shootAt(2, 3);
		ocean.shootAt(2, 4);
		ocean.shootAt(2, 5);
		ocean.shootAt(2, 6);
		ocean.shootAt(2, 3);
		ocean.shootAt(2, 3);
		ocean.shootAt(2, 3);
		assertEquals(ocean.getHitCount(),7);
	}
	
	@Test
	public void testIsGameOver(){
		setUp();
		battleShip.placeShipAt(1, 5, true, ocean);
		cruiser.placeShipAt(3, 1, false, ocean);
		destroyer.placeShipAt(8, 8, true, ocean);
		ocean.shootAt(1, 5);
		ocean.shootAt(1, 6);
		ocean.shootAt(1, 7);
		ocean.shootAt(1, 8);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(3, 1);
		ocean.shootAt(4, 1);
		ocean.shootAt(5, 1);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(8, 8);
		ocean.shootAt(8, 9);
		assertTrue(ocean.isGameOver());
	}
	
	@Test
	public void testGetShipArray(){
		setUp();
		battleShip.placeShipAt(0, 0, true, ocean);
		cruiser.placeShipAt(2, 0, true, ocean);
		destroyer.placeShipAt(4, 0, true, ocean);
		submarine.placeShipAt(6, 0, true, ocean);
		assertEquals(ocean.getShipArray()[0][0].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[0][1].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[0][2].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[0][3].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[2][0].getShipType(),"Cruiser");
		assertEquals(ocean.getShipArray()[2][1].getShipType(),"Cruiser");
		assertEquals(ocean.getShipArray()[2][2].getShipType(),"Cruiser");
		assertEquals(ocean.getShipArray()[4][0].getShipType(),"Destroyer");
		assertEquals(ocean.getShipArray()[4][1].getShipType(),"Destroyer");
		assertEquals(ocean.getShipArray()[6][0].getShipType(),"Submarine");
	}
}
