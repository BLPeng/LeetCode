package Arrays;
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int index = -1;
        for (int i=nums.length-1; i>=1; i--){
            if (nums[i-1]<nums[i]) {
                index = i-1;
                break;
            }
        }
        if (index==-1) reverse(nums, 0, nums.length-1);
        else {
            for (int i=nums.length-1; i>index; i--){
            if (nums[i]>nums[index]){
                swap(nums, index, i);
                break;
            }
        }
        reverse(nums, index+1, nums.length-1);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int i, int j){
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
