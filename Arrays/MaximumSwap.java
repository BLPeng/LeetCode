package Arrays;
//Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
//
//Example 1:
//Input: 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
//Example 2:
//Input: 9973
//Output: 9973
//Explanation: No swap.
public class MaximumSwap {
	public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        int[] frequency = new int[10];
        for (int i=0; i<digit.length; i++){
            frequency[digit[i]-'0'] = i;
        }
        for (int i=0; i<digit.length; i++){
            for (int k=9; k>digit[i]-'0'; k--){
                if (frequency[k]>i){
                    char temp = digit[frequency[k]];
                    digit[frequency[k]] = digit[i];
                    digit[i] = temp;
                    return Integer.parseInt(new String(digit));
                }
            }
        }
        return num;
    }
}
