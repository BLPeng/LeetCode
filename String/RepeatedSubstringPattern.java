package String;
//Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//Example 1:
//Input: "abab"
//
//Output: True
//
//Explanation: It's the substring "ab" twice.
//Example 2:
//Input: "aba"
//
//Output: False
//Example 3:
//Input: "abcabcabcabc"
//
//Output: True
//
//Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
        for (int i=(s.length()/2); i>=1; i--){
            if (s.length()%i==0){
                int n = s.length()/i;
                String sub = s.substring(0, i);
                int j=0;
                for (j=1; j<n; j++){
                    if (!sub.equals(s.substring(i*j,i*j+i))) break;
                }
                if (j==n) return true;
            }
        }
        return false;
    }
}
