package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
//Note:
//Each element in the result should appear as many times as it shows in both arrays.
//The result can be in any order.
public class IntersectionofTwoArrays2 {
	public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left1=0, left2=0;
        while (left1<nums1.length && left2<nums2.length){
            if (nums1[left1]<nums2[left2]) left1++;
            else if (nums1[left1]>nums2[left2]) left2++;
            else {
                l.add(nums1[left1]);
                left1++;
                left2++;
            }
        }
        int[] result = new int[l.size()];
        for (int i=0; i<l.size(); i++){
            result[i] = l.get(i);
        }
        return result;
    }
}
