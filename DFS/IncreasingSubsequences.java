package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
//
//Example:
//Input: [4, 6, 7, 7]
//Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
//Note:
//The length of the given array will not exceed 15.
//The range of integer in the given array is [-100,100].
//The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> s = new HashSet<List<Integer>>();
        helper(nums, s, new ArrayList<Integer>(), 0);
        List<List<Integer>> result = new ArrayList<List<Integer>>(s);
        return result;
    }
    public void helper(int[] nums, Set<List<Integer>> s, List<Integer> l, int index){
        if (l.size()>=2) {
            s.add(new ArrayList<Integer>(l));
        }
        for (int i=index; i<nums.length; i++){
            if (l.size()==0 || nums[i]>=l.get(l.size()-1)){
            l.add(nums[i]);
            helper(nums, s, l, i+1);
            l.remove(l.size()-1);
            }
        }
    }
}
