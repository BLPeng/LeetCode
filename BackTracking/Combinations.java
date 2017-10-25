package BackTracking;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        int[] used = new int[n+1];
        helper(n, k, ll, new ArrayList<Integer>(), used);
        return ll;
    }
    public void helper(int n, int k, List<List<Integer>> ll, List<Integer> l, int[] used){
        if (l.size()==k){
            ll.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i=1; i<=n; i++){
            if (used[i]==1) continue;
            l.add(i);
            used[i]=1;
            helper(n, k, ll, l, used);
            l.remove(l.size()-1);
        }
    }
}
