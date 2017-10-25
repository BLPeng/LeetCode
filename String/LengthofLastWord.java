package String;
//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example, 
//Given s = "Hello World",
//return 5.
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
        String temp = s.trim();
        int count=0;
        for (int i=temp.length()-1; i>=0; i--){
            if (temp.charAt(i)!=' ') count++;
            else break;
        }
        return count;
    }
}
