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
public class ShipTest {
	
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
	public void testGetLength() {
		setUp();
		assertEquals(battleShip.getLength(),4);
		assertEquals(cruiser.getLength(),3);
		assertEquals(destroyer.getLength(),2);
		assertEquals(submarine.getLength(),1);
		assertEquals(emptySea.getLength(),1);
	}
	
	@Test
	public void testGetShipType(){
		setUp();
		assertEquals(battleShip.getShipType(),"Battleship");
		assertEquals(cruiser.getShipType(),"Cruiser");
		assertEquals(destroyer.getShipType(),"Destroyer");
		assertEquals(submarine.getShipType(),"Submarine");
		assertEquals(emptySea.getShipType(),"EmptySea");
	}
	
	@Test
	public void testGetBowRow(){
		setUp();
		battleShip.placeShipAt(0, 0, true, ocean);
		cruiser.placeShipAt(2, 2, true, ocean);
		destroyer.placeShipAt(4, 4, true, ocean);
		submarine.placeShipAt(6, 6, true, ocean);
		assertEquals(battleShip.getBowRow(), 0);
		assertEquals(cruiser.getBowRow(), 2);
		assertEquals(destroyer.getBowRow(), 4);
		assertEquals(submarine.getBowRow(), 6);
	}
	
	@Test
	public void testGetBowColumn(){
		setUp();
		battleShip.placeShipAt(0, 0, true, ocean);
		cruiser.placeShipAt(2, 2, true, ocean);
		destroyer.placeShipAt(4, 4, true, ocean);
		submarine.placeShipAt(6, 6, true, ocean);
		assertEquals(battleShip.getBowColumn(), 0);
		assertEquals(cruiser.getBowColumn(), 2);
		assertEquals(destroyer.getBowColumn(), 4);
		assertEquals(submarine.getBowColumn(), 6);
	}

	@Test
	public void testSetBowRow(){
		setUp();
		battleShip.setBowRow(1);
		cruiser.setBowRow(2);
		destroyer.setBowRow(3);
		submarine.setBowRow(4);
		emptySea.setBowRow(5);
		assertEquals(battleShip.getBowRow(),1);
		assertEquals(cruiser.getBowRow(),2);
		assertEquals(destroyer.getBowRow(),3);
		assertEquals(submarine.getBowRow(),4);
		assertEquals(emptySea.getBowRow(),5);
	}
	
	@Test
	public void testSetBowColumn(){
		setUp();
		battleShip.setBowColumn(1);
		cruiser.setBowColumn(2);;
		destroyer.setBowColumn(3);;
		submarine.setBowColumn(4);;
		emptySea.setBowColumn(5);;
		assertEquals(battleShip.getBowColumn(),1);
		assertEquals(cruiser.getBowColumn(),2);
		assertEquals(destroyer.getBowColumn(),3);
		assertEquals(submarine.getBowColumn(),4);
		assertEquals(emptySea.getBowColumn(),5);
	}
	
	@Test
	public void testIsHorizontal(){
		setUp();
		battleShip.setHorizontal(false);
		cruiser.setHorizontal(true);
		destroyer.setHorizontal(true);
		submarine.setHorizontal(false);
		emptySea.setHorizontal(true);
		assertFalse(battleShip.isHorizontal());
		assertTrue(cruiser.isHorizontal());
		assertTrue(destroyer.isHorizontal());
		assertFalse(submarine.isHorizontal());
		assertTrue(emptySea.isHorizontal());	
	}
	
	@Test
	public void testSetHorizontal(){
		setUp();
		battleShip.setHorizontal(false);
		cruiser.setHorizontal(true);
		destroyer.setHorizontal(true);
		submarine.setHorizontal(false);
		emptySea.setHorizontal(true);
		assertEquals(battleShip.horizontal, false);
		assertEquals(cruiser.horizontal, true);
		assertEquals(destroyer.horizontal, true);
		assertEquals(submarine.horizontal, false);
		assertEquals(emptySea.horizontal, true);
	}
	
	@Test
	public void testOkToPlaceShipAt(){
		setUp();
		battleShip.placeShipAt(2, 8, false, ocean);
		assertTrue(cruiser.okToPlaceShipAt(3, 1, true, ocean));
		assertTrue(destroyer.okToPlaceShipAt(7, 9, false, ocean));
		assertTrue(submarine.okToPlaceShipAt(8, 0, true, ocean));
		assertFalse(battleShip.okToPlaceShipAt(0, 7, true, ocean));
		assertFalse(cruiser.okToPlaceShipAt(8, 5, false, ocean));
		assertFalse(destroyer.okToPlaceShipAt(2, 10, false, ocean));
		assertFalse(submarine.okToPlaceShipAt(-4, 4, true, ocean));
		cruiser.placeShipAt(5, 5, false, ocean);
		assertFalse(cruiser.okToPlaceShipAt(6, 4, true, ocean));
		submarine.placeShipAt(3, 4, true, ocean);
		assertFalse(submarine.okToPlaceShipAt(3, 4, false, ocean));
		battleShip.placeShipAt(4, 7, false, ocean);
		assertFalse(cruiser.okToPlaceShipAt(3, 4, true, ocean));
		assertFalse(cruiser.okToPlaceShipAt(3, 7, true, ocean));
		assertFalse(cruiser.okToPlaceShipAt(7, 8, false, ocean));
	}
	
	@Test
	public void testPlaceShipAt(){
		setUp();
		battleShip.placeShipAt(0, 1, true, ocean);
		cruiser.placeShipAt(5, 2, false, ocean);
		destroyer.placeShipAt(7, 3, true, ocean);
		submarine.placeShipAt(6, 8, false, ocean);
		assertEquals(battleShip.getBowColumn(),1);
		assertEquals(battleShip.getBowRow(),0);
		assertTrue(battleShip.isHorizontal());
		assertEquals(cruiser.getBowColumn(),2);
		assertEquals(cruiser.getBowRow(),5);
		assertFalse(cruiser.isHorizontal());
		assertEquals(destroyer.getBowColumn(),3);
		assertEquals(destroyer.getBowRow(),7);
		assertTrue(destroyer.isHorizontal());
		assertEquals(submarine.getBowColumn(),8);
		assertEquals(submarine.getBowRow(),6);
		assertFalse(submarine.isHorizontal());
	}
	
	@Test
	public void testShootAt(){
		setUp();
		assertFalse(emptySea.shootAt(4, 6));
		battleShip.placeShipAt(2, 0, true, ocean);
		assertTrue(battleShip.shootAt(2, 1));
		assertTrue(battleShip.shootAt(2, 1));
	    assertTrue(battleShip.shootAt(2, 0));
	    assertTrue(battleShip.shootAt(2, 2));
	    assertTrue(battleShip.shootAt(2, 3));
	    assertFalse(battleShip.shootAt(2, 1));
	    for (int i=0; i<battleShip.hit.length; i++){
	    	assertTrue(battleShip.hit[i]);
	    }
	}
	
	@Test
	public void testIsSunk(){
		setUp();
		assertFalse(emptySea.isSunk());
		cruiser.placeShipAt(4, 5, false, ocean);
		cruiser.shootAt(4, 5);
		cruiser.shootAt(5, 5);
		cruiser.shootAt(6, 5);
		assertTrue(cruiser.isSunk());
	}
	
	@Test
	public void testToString(){
		setUp();
		assertEquals(emptySea.toString(),"-");
		destroyer.placeShipAt(3, 3, true, ocean);
		assertEquals(destroyer.toString(),"S");
		destroyer.shootAt(3, 3);
		assertEquals(destroyer.toString(),"S");
		destroyer.shootAt(3, 4);
		assertEquals(destroyer.toString(),"x");
	}
}
