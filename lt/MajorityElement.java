import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MajorityElement {
	
	public int majorityElement(int[] nums){
		Arrays.sort(nums);
		int i = 0;
		for (i=0; i<nums.length-1; i++){
			int count = 1;
			while (nums[i]==nums[i+1]){
				count ++;
			}
			if (count>(nums.length/2)) break;
		}
		return nums[i];
	}

	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,4,3,2,1,5,5,5,5,5,5,5,5};
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(a));
        Queue q = new LinkedList();
        q
	}

}
