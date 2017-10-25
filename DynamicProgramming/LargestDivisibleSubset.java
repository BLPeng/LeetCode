package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

//If there are multiple solutions, return any subset is fine.

//Example 1:

//nums: [1,2,3]

//Result: [1,2] (of course, [1,3] will also be ok)
//Example 2:

//nums: [1,2,4,8]

//Result: [1,2,4,8]

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        if (nums.length==0) return l;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i]%nums[j]==0) dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int index=0;
        for (int i=1; i<nums.length; i++){
            index = (dp[i]>dp[index]) ? i : index;
        }
        int temp = nums[index];
        int tempdp = dp[index];
        for (int i=index; i>=0; i--){
            if (dp[i]==tempdp && temp%nums[i]==0){
                l.add(0,nums[i]);
                temp = nums[i];
                tempdp--;
            }
        }
        return l;
    }
}
