package String;
//Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//Example 1:
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
public class ReverseWordsinaString3 {
	// public String reverseWords(String s) {
    //     String[] temp = s.split("\\s+");
    //     for (int i=0; i<temp.length; i++){
    //         char[] c = temp[i].toCharArray();
    //         int left=0, right=c.length-1;
    //         while (left<right){
    //             char a = c[left];
    //             c[left] = c[right];
    //             c[right] = a;
    //             left++;
    //             right--;
    //         }
    //         temp[i] = new String(c);
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for (int i=0; i<temp.length; i++){
    //         if (i<temp.length-1) sb.append(temp[i]).append(" ");
    //         else sb.append(temp[i]);
    //     }
    //     return sb.toString();
    // }
    public String reverseWords(String s) {
        String[] temp = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<temp.length; i++){
            char[] a = temp[i].toCharArray();
            for (int j=a.length-1; j>=0; j--){
                sb.append(a[j]);
            }
            if (i!=temp.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}
