package Stack;

import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i=0; i<tokens.length; i++){
            if (Character.isDigit(tokens[i].charAt(tokens[i].length()-1))) s.push(Integer.parseInt(tokens[i]));
            else {
                int sum=0;
                int a=s.peek();
                s.pop();
                int b=s.peek();
                s.pop();
                if (tokens[i].equals("+")) sum=a+b;
                else if (tokens[i].equals("-")) sum=b-a;
                else if (tokens[i].equals("*")) sum=a*b;
                else sum=b/a;
                s.push(sum);
            }
        }
        return s.pop();
    }
}
