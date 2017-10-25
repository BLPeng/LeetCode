package String;
//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if (s==null || s.trim().equals("")) return true;
        char[] temp = s.toUpperCase().toCharArray();
        int left=0, right=temp.length-1;
        while (left<right) {
            while (left<right && !Character.isLetterOrDigit(temp[left])) left++;
            while (right>left && !Character.isLetterOrDigit(temp[right])) right--;
            if (temp[left]==temp[right]){
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
