import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		Arrays.sort(nums);
		for (int i=0; i<nums.length-3; i++){
			for (int j=i+1; j<nums.length-2; j++){
				int sum = target-nums[i]-nums[j];
				int k=j+1, g=nums.length-1;
				while (k<g){
					if (nums[k]+nums[g]==sum){
						if (!ll.contains(Arrays.asList(nums[i],nums[j],nums[k],nums[g]))){
							ll.add(Arrays.asList(nums[i],nums[j],nums[k],nums[g]));
						}
						while (i<nums.length-3 && nums[i]==nums[i+1]) i++; //四个循环消除重复答案组；
						while (j<nums.length-2 && nums[j]==nums[j-1]) j++;
						while (k<g && nums[k]==nums[k-1]) k++;
						while (k<g && nums[g]==nums[g-1]) g--;
						k++;
						g--;
					}
					if (nums[k]+nums[g]<sum){
						k++;
					} else g--;
				}
			}
		}
		return ll;
//		List<List<Integer>> ll = new ArrayList<List<Integer>>();
//		findFourSum(ll, new ArrayList<Integer>(), nums, target, 0);
//		return ll;
//	}
//	public void findFourSum(List<List<Integer>> ll, List<Integer> l, int[] nums, int remains, int index){
//		if (remains==0){
//			if (!ll.contains(new ArrayList<Integer>(l)) && l.size()==4) ll.add(new ArrayList<Integer>(l));
//		} else {
//			for (int i=index; i<nums.length; i++){
//				l.add(nums[i]);
//				findFourSum(ll, l, nums, remains-nums[i], i+1);
//				l.remove(l.size()-1);
//			}
//		}
	}

	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] nums = {1,0,0,-1,2,-2};
		System.out.print(fs.fourSum(nums, 2));

	}

}
