package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard
//Example 1:
//Input: ["Hello", "Alaska", "Dad", "Peace"]
//Output: ["Alaska", "Dad"]
public class KeyboardRow {
	public String[] findWords(String[] words) {
        String[] sample = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i=0; i<sample.length; i++){
            for (int j=0; j<sample[i].length(); j++){
                hm.put(sample[i].charAt(j), i);
            }
        }
        List<String> l = new ArrayList<String>();
        for (int i=0; i<words.length; i++){
            if (words[i].equals("")) continue;
            int index = hm.get(words[i].toUpperCase().charAt(0));
            for (int j=0; j<words[i].length(); j++){
                if (hm.get(words[i].toUpperCase().charAt(j))!=index){
                    index = -1;
                    break;
                }
            }
            if (index!=-1) l.add(words[i]);
        }
        return l.toArray(new String[0]);
    }
}
