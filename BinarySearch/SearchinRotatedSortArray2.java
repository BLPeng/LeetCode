package BinarySearch;
//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Write a function to determine if a given target is in the array.
//
//The array may contain duplicates.
public class SearchinRotatedSortArray2 {
	public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = left+ (right-left)/2;
            if (nums[mid]==target) return true;
            else if (nums[mid]<nums[right]) {
                if (target>nums[mid] && target<=nums[right]) left = mid+1;
                else right = mid-1;
            }
            else if (nums[mid]>nums[right]) { //用right来做比较
                if (target<nums[mid] && target>=nums[left]) right = mid-1;
                else left = mid+1;
            }
            else right--;
        }
        return false;
    }
}
