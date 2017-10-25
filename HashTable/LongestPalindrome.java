package HashTable;

import java.util.HashSet;
import java.util.Set;

//Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//Note:
//Assume the length of given string will not exceed 1,010.
//
//Example:
//
//Input:
//"abccccdd"
//
//Output:
//7
//
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.
public class LongestPalindrome {
	// public int longestPalindrome(String s) {
    //     int[] frequency = new int[256];
    //     for (char c : s.toCharArray()) frequency[c]++;
    //     int sum=0, odd=0;
    //     for (int a : frequency) {
    //         if (a%2==0) sum += a;
    //         else {
    //             sum += (a-1);
    //             odd = 1;
    //         }
    //     }
    //     return sum+odd;
    // }
    public int longestPalindrome(String s) {
        Set<Character> hs = new HashSet<Character>();
        int count=0;
        for (int i=0; i<s.length(); i++){
            if (hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) return count*2+1;
        return count*2;
    }
}
