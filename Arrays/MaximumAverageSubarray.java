package Arrays;
//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
//
//Example 1:
//Input: [1,12,-5,-6,50,3], k = 4
//Output: 12.75
//Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
public class MaximumAverageSubarray {
	public double findMaxAverage(int[] nums, int k) {
        int sum=0, max=Integer.MIN_VALUE;
        int count=k, left=0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            count--;
            if (count==0){
                max = Math.max(max,sum);
                sum -= nums[left];
                left++;
                count++;
            }
        }
        return ((double)max)/((double)k);
    }
}
