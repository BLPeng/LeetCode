package BinarySearch;
//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left=0, right=nums.length-1;
        while (left<=right){
            if (nums[left]==nums[right] && nums[left]==target) return new int[]{left,right}; //edge case[2,2];
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                if (mid==0) return new int[]{0,0}; //edge case,找的那个target有且仅有一个，在边上
                if (mid==nums.length-1) return new int[]{nums.length-1,nums.length-1};
                int start = mid-1, end = mid+1;
                while (start>=0 && nums[start]==target) start--;
                while (end<nums.length && nums[end]==target) end++;
                result[0]=start+1;
                result[1]=end-1;
                return result;
            } else if (nums[mid]<target && target<=nums[right]) left=mid+1;
            else right=mid-1;
        }
        return new int[]{-1,-1};
    }
}
