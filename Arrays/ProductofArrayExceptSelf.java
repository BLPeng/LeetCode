package Arrays;
//Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Solve it without division and in O(n).
//
//For example, given [1,2,3,4], return [24,12,8,6].
public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=1;
        for (int i=1; i<nums.length; i++){
            dp[i]=dp[i-1]*nums[i-1];
        }
        int right=1;
        for (int i=nums.length-1; i>=0; i--){
            dp[i] *= right;
            right *= nums[i];
        }
        return dp;
    }
}
