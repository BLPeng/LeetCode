package Arrays;
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count=m+n-1;
        int right1=m-1, right2=n-1;
        while (right1>=0 && right2>=0){
            if (nums1[right1]>nums2[right2]) nums1[count--]=nums1[right1--];
            else nums1[count--]=nums2[right2--];
        }
        while (right2>=0) nums1[count--]=nums2[right2--];
    }
}
