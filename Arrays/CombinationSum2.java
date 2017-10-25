package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
//A solution set is: 
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, ll, new ArrayList<Integer>(), target, 0);
        return ll;
    }
    public void helper(int[] candidates, List<List<Integer>> ll, List<Integer> l, int target, int index){
        if (target<0) return;
        if (target==0) {
            ll.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i=index; i<candidates.length; i++){
            if (i>index && candidates[i]==candidates[i-1]) continue;
                l.add(candidates[i]);
                helper(candidates, ll, l, target-candidates[i], i+1);
                l.remove(l.size()-1);
        }
    }
}
