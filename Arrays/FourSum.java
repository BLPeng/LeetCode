package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note: The solution set must not contain duplicate quadruplets.
//
//For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        for (int i=0; i<nums.length-3; i++){
            for (int j=i+1; j<nums.length-2; j++){
                int left=j+1, right=nums.length-1;
                while (left<right){
                    if (nums[i]+nums[j]+nums[left]+nums[right]==target && !ll.contains(Arrays.asList(nums[i],nums[j],nums[left],nums[right]))){
                        ll.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //while (i<nums.length-3 && nums[i]==nums[i+1]) i++;
                        //while (j<nums.length-2 && nums[j]==nums[j+1]) j++;
                        while (left<right && nums[left]==nums[left+1]) left++;
                        while (left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    } 
                    else if (nums[i]+nums[j]+nums[left]+nums[right]<target) left++;
                    else right--;  
                }
            }
        }
        return ll;
    }
}
