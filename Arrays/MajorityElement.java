package Arrays;
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {
	public int majorityElement(int[] nums) {
        int number=nums[0], count=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==number) count++;
            else if (count==0) {
                number=nums[i];
                count=1;
            } else count--;
        }
        return number;
    }
}
