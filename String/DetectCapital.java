package String;
//Given a word, you need to judge whether the usage of capitals in it is right or not.
//
//We define the usage of capitals in a word to be right when one of the following cases holds:
//
//All letters in this word are capitals, like "USA".
//All letters in this word are not capitals, like "leetcode".
//Only the first letter in this word is capital if it has more than one letter, like "Google".
//Otherwise, we define that this word doesn't use capitals in a right way.
//Example 1:
//Input: "USA"
//Output: True
//Example 2:
//Input: "FlaG"
//Output: False
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
        String upper = word.toUpperCase();
        String lower = word.toLowerCase();
        if (word.equals(upper) || word.equals(lower)) return true;
        else {
            if (word.charAt(0)-'a'>=0 && word.charAt(0)-'a'<=25) return false;
            else {
                String temp = word.substring(1,word.length()).toLowerCase();
                if (temp.equals(word.substring(1,word.length()))) return true;
                else return false;
            }
        }
    }
}
