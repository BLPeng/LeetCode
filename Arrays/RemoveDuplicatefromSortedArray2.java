package Arrays;

import java.util.HashMap;

//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array nums = [1,1,1,2,2,3],
//
//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
public class RemoveDuplicatefromSortedArray2 {
	public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int count=0;
        for (int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
            if (hm.get(nums[i])>2) continue;
            else nums[count++]=nums[i];
        }
        return count;
    }
}
