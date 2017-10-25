package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, ll, new ArrayList<Integer>(), 0);
        return ll;
    }
    public void helper(int[] nums, List<List<Integer>> ll, List<Integer> l, int index){
        ll.add(new ArrayList<Integer>(l));
        for (int i=index; i<nums.length; i++){
            if (i>index && nums[i]==nums[i-1]) continue;
            l.add(nums[i]);
            helper(nums, ll, l, i+1);
            l.remove(l.size()-1);
        }
    }
}
