package DFS;

import java.util.Arrays;

//Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
//Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
//
//Example 1:
//Input: [1,1,2,2,2]
//Output: true
//
//Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
//Example 2:
//Input: [3,3,3,3,4]
//Output: false
//
//Explanation: You cannot find a way to form a square with all the matchsticks.
public class MatchstickstoSquare {
	public boolean makesquare(int[] nums) {
        if (nums.length==0 || nums.length<4) return false;
        Arrays.sort(nums);
        int sum=0;
        for (int i=0; i<nums.length; i++) sum += nums[i];
        if (sum%4!=0) return false;
        Reverse(nums);
        return helper(nums, new int[4], 0, sum/4);
    }
    public boolean helper(int[] nums, int[] sum, int index, int target){
        if (index==nums.length){
            if (sum[0]==target && sum[1]==target && sum[2]==target) return true;
            else return false;
        } 
        for (int i=0; i<4; i++){
            if (sum[i]+nums[index]>target) continue;
            sum[i] += nums[index];
            if (helper(nums, sum, index+1, target)) return true;
            sum[i] -= nums[index];
        }
        return false;
    }
    public void Reverse(int[] nums){
        int left=0, right=nums.length-1;
        while (left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
