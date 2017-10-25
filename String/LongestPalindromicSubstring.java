package String;
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//Example:
//
//Input: "babad"
//
//Output: "bab"
//
//Note: "aba" is also a valid answer.
//Example:
//
//Input: "cbbd"
//
//Output: "bb"
public class LongestPalindromicSubstring {
	int count=0;
    String result = "";
    public String longestPalindrome(String s) {
        for (int i=0; i<s.length(); i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return result;
    }
    public void helper(String s, int left, int right){
        while (left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if (right-left-1>count){
            result = s.substring(left+1, right);
            count = right-left-1;
        }
    }
}
