package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note: The solution set must not contain duplicate triplets.
//
//For example, given array S = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, ll, new ArrayList<Integer>(), 0);
        return ll;
    }
    public void helper(int[] nums, List<List<Integer>> ll, List<Integer> l, int index){
        if (l.size()>3) return;
        if (l.size()==3 && l.get(0)+l.get(1)+l.get(2)==0){
            if (!ll.contains(new ArrayList<Integer>(l))) ll.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i=index; i<nums.length; i++){
            l.add(nums[i]);
            helper(nums, ll, l, i+1);
            l.remove(l.size()-1);
        }
    }
}
