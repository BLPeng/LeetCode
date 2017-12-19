/**
 * Name: Bolu Peng
 * PennId: 16847239
 * Statement：I finished this assignment all by myself
 */
package battleship;

import java.util.Scanner;

/**
 * @author bolupeng
 *
 */
public class BattleshipGame {
	
	public int row;
	public int column;
	public Ocean ocean;
	public Scanner input = new Scanner(System.in);

	
	public void setUp(){
		ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		System.out.println("Game Start!");
		ocean.print();
	}
	
	/**
	 * Check the player's input
	 * Input should be valid numbers between 0 and 9
	 */
	public void checkInput(){
		while (true){
			System.out.print("Please input a row number: ");
			String typedRow = input.nextLine();
			System.out.print("Please input a column number: ");
			String typedColumn = input.nextLine();
			if (typedRow.trim()!=null && typedColumn.trim()!=null){
				if (typedRow.trim().matches("^[0-9]+$") && typedColumn.trim().matches("^[0-9]+$")){
					row = Integer.parseInt(typedRow.trim());
					column = Integer.parseInt(typedColumn.trim());
					if (row>9 || row<0 || column>9 || column<0){
						System.out.println("Please input number(s) between 0-9!");
					}
					else{
						break;
					}
				}
				else{
					System.out.println("Please input valid number(s)!");
				}
			}
			else{
				System.out.println("Please input valid number(s)!");
			}
		}
	}
	
	// Display the ocean to player
	public void display(){
		if (ocean.shootAt(row, column)){
			if (ocean.getShipArray()[row][column].isSunk()){
				System.out.println("You just sank a "+ocean.getShipArray()[row][column].getShipType()+"!");
			}
			else{
				System.out.println("You just hit a ship!");
			}
		}	
		else{
			System.out.println("You just missed!");
		}
		ocean.print();
	}
	
	/**
	 *  Ask player if he/she wants to play again
	 *  The player can type in "YES" or "Yes" or "yes" to continue or type in "NO" or "No" or "no" to exit
	 */
	public boolean playAgain(){
		System.out.print("Wanna play again? Please input \"yes\" or \"no\": ");
		String answer = input.nextLine();
		while (!answer.equals("yes") && !answer.equals("no") && !answer.equals("Yes") && !answer.equals("No") && !answer.equals("YES") && !answer.equals("NO")){
			System.out.print("Wanna play again? Please input \"yes\" or \"no\": ");
			answer = input.nextLine();
		}
		if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){
		BattleshipGame battleshipgame = new BattleshipGame();
		battleshipgame.setUp();
		while (true){
			while (!battleshipgame.ocean.isGameOver()){
				battleshipgame.checkInput();
				battleshipgame.display();
			}
			System.out.println("You have shot "+battleshipgame.ocean.getShotsFired()+" times in total!");
			System.out.println("You have successfully hit "+battleshipgame.ocean.getHitCount()+" times in total!");
			System.out.println("Game over!");
			if (battleshipgame.playAgain()){
				battleshipgame.setUp();
			}
			else{
				break;
			}
		}
	}
}
