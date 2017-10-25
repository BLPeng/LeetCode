package DFS;
import java.util.Stack;
//Given an encoded string, return it's decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//Examples:
//
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
public class DecodeString {
	public String decodeString(String s) {
        String result = "";
        Stack<Integer> is = new Stack<Integer>();
        Stack<String> ss = new Stack<String>();
        int left=0;
        while (left<s.length()){
            if (Character.isDigit(s.charAt(left))){
                int integer=0;
                while (Character.isDigit(s.charAt(left))){
                    integer = 10*integer + (s.charAt(left)-'0');
                    left++;
                }
                is.push(integer);
            } else if (s.charAt(left)=='['){
                ss.push(result);
                result="";
                left++;
            } else if (s.charAt(left)==']'){
                StringBuilder sb = new StringBuilder(ss.pop());
                int count = is.pop();
                for (int i=0; i<count; i++){
                    sb.append(result);
                }
                result = sb.toString();
                left++;
            } else {
                result += s.charAt(left++);
            }
        }
        return result;
    }
}
