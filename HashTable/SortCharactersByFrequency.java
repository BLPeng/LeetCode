package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Given a string, sort it in decreasing order based on the frequency of characters.
//
//Example 1:
//
//Input:
//"tree"
//
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//Example 2:
//
//Input:
//"cccaaa"
//
//Output:
//"cccaaa"
//
//Explanation:
//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
//Example 3:
//
//Input:
//"Aabb"
//
//Output:
//"bbAa"
//
//Explanation:
//"bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        if (s==null) return null;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int max = 0;
        for (int i=0; i<s.length(); i++){
            if (!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),0);
            }
            hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            max = Math.max(max, hm.get(s.charAt(i)));
        }
        List<Character>[] array = buildArray(hm, max);
        return buildString(array);
    }
    
    public List<Character>[] buildArray(Map<Character, Integer> map, int maxcount){
        List<Character>[] array = new List[maxcount+1]; //array长度就是出现频率最大次数加1;
        for (char c : map.keySet()){
            int count = map.get(c);
            if (array[count]==null){
                array[count]=new ArrayList();
            }
            array[count].add(c);
        }
        return array;
    }
    
    public String buildString(List<Character>[] array){
        StringBuilder s = new StringBuilder();
        for (int i=array.length-1; i>0; i--){
            List<Character> l = array[i];
            if (l!=null){
                for (char c : l){
                    for (int j=i; j>0; j--){
                        s.append(c);
                    }
                }    
            }
        }
        return s.toString();
    }
}
