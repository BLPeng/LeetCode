package String;
//Write a function that takes a string as input and reverse only the vowels of a string.
//
//Example 1:
//Given s = "hello", return "holle".
//
//Example 2:
//Given s = "leetcode", return "leotcede".
//
//Note:
//The vowels does not include the letter "y".
public class ReverseVowelsofaString {
	public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left=0, right=s.length()-1;
        while (left<right){
            if ((s.charAt(left)=='a' || s.charAt(left)=='e' || s.charAt(left)=='i' || s.charAt(left)=='o' || s.charAt(left)=='u' || s.charAt(left)=='A' || s.charAt(left)=='E' || s.charAt(left)=='I' || s.charAt(left)=='O' || s.charAt(left)=='U') && (s.charAt(right)=='a' || s.charAt(right)=='e' || s.charAt(right)=='i' || s.charAt(right)=='o' || s.charAt(right)=='u' || s.charAt(right)=='A' || s.charAt(right)=='E' || s.charAt(right)=='I' || s.charAt(right)=='O' || s.charAt(right)=='U')) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            } else {
                if (s.charAt(left)!='a' && s.charAt(left)!='e' && s.charAt(left)!='i' && s.charAt(left)!='o' && s.charAt(left)!='u' && s.charAt(left)!='A' && s.charAt(left)!='E' && s.charAt(left)!='I' && s.charAt(left)!='O' && s.charAt(left)!='U') left++;
                if (s.charAt(right)!='a' && s.charAt(right)!='e' && s.charAt(right)!='i' && s.charAt(right)!='o' && s.charAt(right)!='u' && s.charAt(right)!='A' && s.charAt(right)!='E' && s.charAt(right)!='I' && s.charAt(right)!='O' && s.charAt(right)!='U') right--;
            }
        }
        return new String(c);
    }
}
