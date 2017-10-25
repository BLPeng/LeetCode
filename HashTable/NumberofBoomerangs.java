package HashTable;

import java.util.HashMap;

//Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
//
//Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
//
//Example:
//Input:
//[[0,0],[1,0],[2,0]]
//
//Output:
//2
//
//Explanation:
//The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
public class NumberofBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
        int result=0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<points.length; i++){
            for (int j=0; j<points.length; j++){
                if (i==j) continue;
                int dis = helper(points[i],points[j]);
                hm.put(dis,hm.getOrDefault(dis,0)+1);
            }
            for (int value : hm.values()) result += value*(value-1);
            hm.clear();
        }
        return result;
    }
    public int helper(int[] a, int[] b){
        int x = a[0]-b[0];
        int y = a[1]-b[1];
        return x*x + y*y;
    }
}
