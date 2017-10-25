package Arrays;

import java.util.HashSet;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int result=0;
        for (int num : nums) hs.add(num);
        for (int num : nums) {
            if (hs.remove(num)){
                int left=num-1, right=num+1;
                while (hs.remove(left)) left--;
                while (hs.remove(right)) right++;
                result = Math.max(result,right-1-left-1+1);
            }
        }
        return result;
    }
}
