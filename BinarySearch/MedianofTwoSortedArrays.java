package BinarySearch;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//Example 1:
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
//Example 2:
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length!=0) return nums2.length%2 == 1 ? (float)nums2[nums2.length/2] : (float)(nums2[nums2.length/2]+nums2[(nums2.length/2)-1])/2;
        if(nums1.length!=0 && nums2.length==0) return nums1.length%2 == 1 ? (float)nums1[nums1.length/2] : (float)(nums1[nums1.length/2]+nums1[(nums1.length/2)-1])/2;
        int[] result = new int[nums1.length+nums2.length];
        int l1 = 0;
        int l2 = 0;
        int r = 0;
        while(l1<nums1.length && l2<nums2.length){
            if(nums1[l1]<nums2[l2]){
                result[r++] = nums1[l1++];
            } else {
                result[r++] = nums2[l2++];
            }
        }
        while (l1==0 || l1<nums1.length-1){
            result[r++] = nums1[l1++];
        }
        while (l2==0 || l2<nums2.length-1){
            result[r++] = nums2[l2++];
        }
        return result.length%2 == 1 ? (float)result[result.length/2] : (float)(result[result.length/2]+result[(result.length/2)-1])/2;
    }
}
