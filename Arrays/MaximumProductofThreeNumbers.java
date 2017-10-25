package Arrays;
//Given an integer array, find three numbers whose product is maximum and output the maximum product.
//
//Example 1:
//Input: [1,2,3]
//Output: 6
//Example 2:
//Input: [1,2,3,4]
//Output: 24
public class MaximumProductofThreeNumbers {
	public int maximumProduct(int[] nums) {
        int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=Integer.MIN_VALUE, min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i]>max3){
                max3 = nums[i];
            }
            if (nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i]<min2){
                min2 = nums[i];
            }
        }
        return max1*max2*max3 > max1*min1*min2 ? max1*max2*max3 : max1*min1*min2;
    }
}
