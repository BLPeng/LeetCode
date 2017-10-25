package HashTable;

import java.util.Arrays;

//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//
//Note:
//You may assume the string contains only lowercase alphabets.
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i=0; i<s1.length; i++){
            if (s1[i]!=t1[i]) return false;
        }
        return true;
    }
}
