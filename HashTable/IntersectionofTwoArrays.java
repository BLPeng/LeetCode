package HashTable;

import java.util.HashSet;
import java.util.Set;

//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//Note:
//Each element in the result must be unique.
//The result can be in any order.
public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for (int i : nums1) s.add(i);
        for (int i : nums2) {
            if (s.contains(i)) intersect.add(i);
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) result[i++] = num;
        return result;
    }
}
