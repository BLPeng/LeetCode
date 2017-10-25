package Arrays;
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//For example,
//Given nums = [0, 1, 3] return 2.
//
//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
public class MissingNumber {
	public int missingNumber(int[] nums) {
        for (int i=0; i<nums.length; i++){
            nums[Math.abs(nums[i])] *= -1;
        }
        int i=0;
        for (i=0; i<nums.length; i++){
            if (nums[i]>0) {
                break;
            }
        }
        return i==0? 1 : i;
    }
}
