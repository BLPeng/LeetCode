package BinarySearch;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//You may assume no duplicate exists in the array.
public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
        int left=0, right=nums.length-1,result=Integer.MAX_VALUE;
        while (left<right){
            int mid=(left+right)/2;
            result = Math.min(result,Math.min(nums[left],nums[right]));
            if (nums[mid]>nums[left]) left=mid;
            else right=mid;
        }
        return result==Integer.MAX_VALUE?nums[nums.length-1]:result;
    }
}
