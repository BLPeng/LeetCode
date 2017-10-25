package String;
//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
public class ReverseWordsinaString {
	public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=s1.length-1; i>=0; i--){
            if (i!=0) sb.append(s1[i]).append(" ");
            else sb.append(s1[i]);
        }
        return sb.toString();
    }
}
