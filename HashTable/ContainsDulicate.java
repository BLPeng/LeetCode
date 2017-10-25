package HashTable;

import java.util.HashSet;
import java.util.Set;

//Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
public class ContainsDulicate {
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++){
            if (s.contains(nums[i])) return true;
            s.add(nums[i]);
        }
        return false;
    }
}
