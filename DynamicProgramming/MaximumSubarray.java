package lc;
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//the contiguous subarray [4,-1,2,1] has the largest sum = 6.
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        int sum=0, result=Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (sum<0) sum=nums[i];
            else sum += nums[i];
            result = Math.max(result, sum);
        }
        return result;
    }
}
