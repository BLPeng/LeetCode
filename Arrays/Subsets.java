package Arrays;

import java.util.ArrayList;
import java.util.List;

//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        helper(nums, ll, new ArrayList<Integer>(), 0);
        return ll;
    }
    public void helper(int[] nums, List<List<Integer>> ll, List<Integer> l, int index){
        ll.add(new ArrayList<Integer>(l));
        for (int i=index; i<nums.length; i++){
            l.add(nums[i]);
            helper(nums, ll, l, i+1);
            l.remove(l.size()-1);
        }
    }
}
