package HashTable;

import java.util.HashMap;

//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        String[] sample = str.split("\\s+");
        if (pattern.length()!=sample.length) return false;
        HashMap<Character, String> hm = new HashMap<Character, String>();
        for (int i=0; i<sample.length; i++){
            if (hm.containsKey(pattern.charAt(i))){
                if (!hm.get(pattern.charAt(i)).equals(sample[i])) return false;
            } else {
                if (hm.containsValue(sample[i])) return false;
                hm.put(pattern.charAt(i), sample[i]);
            }
        }
        return true;
    }
}
