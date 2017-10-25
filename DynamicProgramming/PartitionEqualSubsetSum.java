package lc;
//Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
//Note:
//Each of the array element will not exceed 100.
//The array size will not exceed 200.
//Example 1:
//
//Input: [1, 5, 11, 5]
//
//Output: true
//
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//Example 2:
//
//Input: [1, 2, 3, 5]
//
//Output: false
//
//Explanation: The array cannot be partitioned into equal sum subsets.

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
        if (nums.length==0) return true;
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if (sum%2!=0) return false;
        else sum /=2;
        boolean[] dp = new boolean[sum+1];
        dp[0]=true;
        for (int i=1; i<nums.length; i++){
            for (int j=sum; j>=nums[i-1]; j--){
                if (j>=nums[i-1]) dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[sum];
    }
}
