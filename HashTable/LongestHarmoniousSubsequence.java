package HashTable;

import java.util.HashMap;
import java.util.Map;

//We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
//
//Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
//
//Example 1:
//Input: [1,3,2,2,5,2,3,7]
//Output: 5
//Explanation: The longest harmonious subsequence is [3,2,2,2,3].
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int max = 0;
        for (int i=0; i<nums.length; i++){
            if (!hm.containsKey(nums[i]+1)) continue;
            else max = Math.max(max,hm.get(nums[i])+hm.get(nums[i]+1));
        }
        return max;
    }
}
