package Arrays;

import java.util.Arrays;

//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class ThreeSumCloset {
	public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int k=i+1, j=nums.length-1;
            while (k<j){
                if (Math.abs(nums[i]+nums[k]+nums[j]-target)<min){
                    min = Math.abs(nums[i]+nums[k]+nums[j]-target);
                    sum = nums[i]+nums[k]+nums[j];
                }
                if (nums[i]+nums[k]+nums[j]<target) k++;
                else j--;
            }
            }
            return sum;
        }
}
