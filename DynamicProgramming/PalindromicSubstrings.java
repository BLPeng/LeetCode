package lc;
//Given a string, your task is to count how many palindromic substrings in this string.
//
//The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//
//Example 1:
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

public class PalindromicSubstrings {
	int count=0;
    public int countSubstrings(String s) {
        for (int i=0; i<s.length(); i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return count;
    }
    public void helper(String s, int start, int end){
        while (start>=0 && end<=s.length()-1 && s.charAt(start)==s.charAt(end)){
            count++;
            start--;
            end++;
        }
    }
}
