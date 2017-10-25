package Arrays;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
public class JumpGame {
	public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i]表示走到i位置时所剩的最大步数；
        for (int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1],nums[i-1])-1;
            if (dp[i]<0) return false;
        }
        return dp[nums.length-1]>=0;
    }
}
