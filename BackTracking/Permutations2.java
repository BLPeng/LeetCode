package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        int[] used = new int[nums.length];
        Arrays.fill(used,0);
        Arrays.sort(nums);
        helper(nums, ll, new ArrayList<Integer>(), used);
        return ll;
    }
    public void helper(int[] nums, List<List<Integer>> ll, List<Integer> l, int[] used){
        if (l.size()==nums.length){
            ll.add(new ArrayList<Integer>(l));
            return;
        } 
        for (int i=0; i<nums.length; i++){
            if (used[i]==1) continue;
            if (i>0 && nums[i-1]==nums[i] && used[i-1]==0) continue;
            l.add(nums[i]);
            used[i]=1;
            helper(nums, ll, l, used);
            l.remove(l.size()-1);
            used[i]=0;
        }
    }
}
