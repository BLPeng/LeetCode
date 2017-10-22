package lc;
import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

//For example, given
//s = "leetcode",
//dict = ["leet", "code"].

//Return true because "leetcode" can be segmented as "leet code".

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i=0; i<s.length(); i++){
            if (wordDict.contains(s.substring(0,i+1))) dp[i]=true;
            for (int j=i+1; j<s.length(); j++){
                if (dp[i]==true && wordDict.contains(s.substring(i+1,j+1))) dp[j]=true;
            }
        }
        return dp[s.length()-1];
    }
}
