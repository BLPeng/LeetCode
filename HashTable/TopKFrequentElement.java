package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given a non-empty array of integers, return the k most frequent elements.
//
//For example,
//Given [1,1,1,2,2,3] and k = 2, return [1,2].
public class TopKFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        List<Integer> l = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for (int key : hm.keySet()){
            int frequency = hm.get(key);
            if (bucket[frequency]==null){
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(key);
        }
        for (int i=bucket.length-1; i>0 && l.size()<k; i--){
            if (bucket[i]!=null) l.addAll(bucket[i]);
        }
        return l;
    }
}
