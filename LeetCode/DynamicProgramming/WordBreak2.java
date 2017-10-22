package lc;
import java.util.List;
import java.util.ArrayList;
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

//Return all such possible sentences.

//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].

//A solution is ["cats and dog", "cat sand dog"].

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i=0; i<s.length(); i++){
            if (wordDict.contains(s.substring(0,i+1))) dp[i]=true;
            for (int j=i+1; j<s.length(); j++){
                if (dp[i]==true && wordDict.contains(s.substring(i+1,j+1))) dp[j]=true;
            }
        }
        List<String> l = new ArrayList<String>();
        if (dp[s.length()-1]==false) return l;
        helper(s, wordDict, l, 0, "");
        return l;
    }
    public void helper(String s, List<String> wordDict, List<String> l, int index, String result){
        if (index==s.length()){
            l.add(result);
            return;
        }
        for (int i=index; i<s.length(); i++){
            if (wordDict.contains(s.substring(index,i+1))){
                helper(s, wordDict, l, i+1, result+((i==s.length()-1)?s.substring(index, i+1):s.substring(index, i+1)+" "));
            }
        }
    }
}
