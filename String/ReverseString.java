package String;
//Write a function that takes a string as input and returns the string reversed.
//
//Example:
//Given s = "hello", return "olleh".
public class ReverseString {
	public String reverseString(String s) {
        char[] a = s.toCharArray();
        int left=0, right=a.length-1;
        while (left<right){
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        return s.valueOf(a);
    }
}
