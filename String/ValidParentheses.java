package String;

import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()) return false;
                else if (s.charAt(i)==')' && stack.peek()!='(') return false;
                else if (s.charAt(i)==']' && stack.peek()!='[') return false;
                else if (s.charAt(i)=='}' && stack.peek()!='{') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
