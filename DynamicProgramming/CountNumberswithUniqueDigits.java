package lc;
//Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

//Example:
//Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

public class CountNumberswithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
        if (n==0) return 1;
        int result=10;
        int digits=9;
        int number=9;
        while (n >1 && number>0){
            digits=digits*number;
            result+=digits;
            number--;
            n--;
        }
        return result;
    }
}
