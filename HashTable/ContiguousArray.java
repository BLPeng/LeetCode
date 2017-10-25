package HashTable;

import java.util.HashMap;
import java.util.Map;

//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//
//Example 1:
//Input: [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
//Example 2:
//Input: [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
public class ContiguousArray {
	public int findMaxLength(int[] nums) {
        for (int i=0; i<nums.length; i++) nums[i] = (nums[i]==0) ? -1 : nums[i];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0,-1);
        int max=0, sum=0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            if (hm.containsKey(sum)){
                max = Math.max(max,i-hm.get(sum));
            } else hm.put(sum,i);
        }
        return max;
    }
}
