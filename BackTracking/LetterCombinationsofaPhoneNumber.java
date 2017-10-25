package BackTracking;

import java.util.ArrayList;
import java.util.List;

//Given a digit string, return all possible letter combinations that the number could represent.
//
//
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class LetterCombinationsofaPhoneNumber {
	String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<String>();
        if (digits==null || digits.length()==0) return l;
        helper(digits, l, 0, "");
        return l;
    }
    public void helper(String digits, List<String> l, int length, String result){
        if (length>=digits.length()){
            l.add(result);
            return;
        }
        String letters = numbers[digits.charAt(length)-'0'];
        for (int i=0; i<letters.length(); i++){
            helper(digits, l, length+1, result+letters.charAt(i));
        }
    }
}
