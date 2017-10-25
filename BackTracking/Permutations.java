package BackTracking;

import java.util.ArrayList;
import java.util.List;

//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        helper(nums, ll, new ArrayList<Integer>());
        return ll;
    }
    public void helper(int[] nums, List<List<Integer>> ll, List<Integer> l){
        if (l.size()==nums.length) {
            ll.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (l.contains(nums[i])) continue;
            l.add(nums[i]);
            helper(nums, ll, l);
            l.remove(l.size()-1);
        }
    }
}
