package Arrays;
//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        int left=0, result=Integer.MAX_VALUE, sum=0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            while (i>=left && sum>=s){
                result = Math.min(result,i-left+1);
                sum -= nums[left++];
            }
        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}
