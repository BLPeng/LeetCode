package Arrays;

import java.util.ArrayList;
import java.util.List;

//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//
//Example 1:
//
//Input: k = 3, n = 7
//
//Output:
//
//[[1,2,4]]
//
//Example 2:
//
//Input: k = 3, n = 9
//
//Output:
//
//[[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        helper(nums, k, ll, new ArrayList<Integer>(), n, 0);
        return ll;
    }
    public void helper(int[] nums, int k, List<List<Integer>> ll, List<Integer> l, int n, int index){
        if (n<0) return;
        if (n==0 && k==l.size()){
            ll.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i=index; i<nums.length; i++){
            l.add(nums[i]);
            helper(nums, k, ll, l, n-nums[i], i+1);
            l.remove(l.size()-1);
        }
    }
}
