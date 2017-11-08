/*
Name: Bolu Peng
PennID: 16847239
Statement: I completed this assignment all by myself 
*/
package fraction;

import java.util.Scanner;

public class FractionCalculator {
	public static void main(String[] args){
		String sample = "acisq+-*/";
		String operator = "+-*/s";
		String single = "aciq";
		// print legal commands
		System.out.println("a –To take the absolute value of the number currently displayed.");
		System.out.println("c –To clear (reset to zero) the calculator.");
		System.out.println("i –To invert the number currently displayed.");
		System.out.println("s n –To discard the number currently displayed and replace it with n.");
		System.out.println("q –To quit the program.");
		System.out.println("+ n –To add n to the number currently displayed.");
		System.out.println("- n –To subtract n from the number currently displayed.");
		System.out.println("* n –To multiply the number currently displayed by n.");
		System.out.println("/ n –To divide the number currently displayed by n.");
		// initialize a calculator that is zero
		Fraction calculator = new Fraction(0);
		System.out.println("Your current result is: "+calculator);
		Scanner input = new Scanner(System.in);
		// prompt and input commands loop
		while (true){
			System.out.print("Please input command and/or fraction:");
			String raw = input.nextLine();
			String commands = raw.trim();
			// split string at space
			String[] command = commands.split("\\s+");
			// computer will repeatedly prompt until a legal command is input
			while (commands.length()==0 || !sample.contains(commands.charAt(0)+"") || (single.contains(commands.charAt(0)+"") && commands.length()>1) || (commands.length()>1 && commands.charAt(1)!=' ') || commands.substring(1,commands.length()).contains("- ") || (operator.contains(commands.charAt(0)+"") && commands.length()==1)){
				System.out.println("Error: please input legal command and fraction");
				System.out.print("Please input command and/or fraction:");
				raw = input.nextLine();
				commands = raw.trim();
				command = commands.split("\\s+");
			}
			String substr = commands.substring(1,commands.length());
			String[] datas = substr.split("/");
			if (command.length>1){
				// replace by n
				if (commands.charAt(0)=='s'){
					if (datas.length==1){
						calculator = new Fraction(Integer.parseInt(datas[0].trim()));
					}else{
						calculator = new Fraction(Integer.parseInt(datas[0].trim()), Integer.parseInt(datas[1].trim()));
					}
				}
				// add n
				else if (commands.charAt(0)=='+'){
					if (datas.length==1){
						calculator = calculator.add(new Fraction(Integer.parseInt(datas[0].trim())));
					}else{
						calculator = calculator.add(new Fraction(Integer.parseInt(datas[0].trim()), Integer.parseInt(datas[1].trim())));
					}
				}
				// subtract n
				else if (commands.charAt(0)=='-'){
					if (datas.length==1){
						calculator = calculator.subtract(new Fraction(Integer.parseInt(datas[0].trim())));
					}else{
						calculator = calculator.subtract(new Fraction(Integer.parseInt(datas[0].trim()), Integer.parseInt(datas[1].trim())));
					}
				}
				// times n
				else if (commands.charAt(0)=='*'){
					if (datas.length==1){
						calculator = calculator.multiply(new Fraction(Integer.parseInt(datas[0].trim())));
					}else{
						calculator = calculator.multiply(new Fraction(Integer.parseInt(datas[0].trim()), Integer.parseInt(datas[1].trim())));
					}
				}
				// divided by n
				else if (commands.charAt(0)=='/'){
					if (datas.length==1){
						calculator = calculator.divide(new Fraction(Integer.parseInt(datas[0].trim())));
					}else{
						calculator = calculator.divide(new Fraction(Integer.parseInt(datas[0].trim()), Integer.parseInt(datas[1].trim())));
					}
				}
			}else{
				if (commands.charAt(0)=='a'){
					calculator = calculator.abs();
				}
				else if (commands.charAt(0)=='c'){
					calculator = new Fraction(0);
				}
				else if (commands.charAt(0)=='i'){
					calculator = calculator.inverse();
				}
				else if (commands.charAt(0)=='q'){
					break;
				}
			}
			System.out.println("Your current result is: "+calculator);
		}
		input.close();
	}
}
