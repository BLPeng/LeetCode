package BackTracking;

import java.util.ArrayList;
import java.util.List;

//Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
//
//The number at the ith position is divisible by i.
//i is divisible by the number at the ith position.
//Now given N, how many beautiful arrangements can you construct?
//
//Example 1:
//Input: 2
//Output: 2
//Explanation: 
//
//The first beautiful arrangement is [1, 2]:
//
//Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
//
//Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
//
//The second beautiful arrangement is [2, 1]:
//
//Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
//
//Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
public class BeautifulArrangement {
	int count=0;
    public int countArrangement(int N) {
        int[] visited = new int[N+1];
        helper(N, new ArrayList<Integer>(), visited);
        return count;
    }
    public void helper(int N, List<Integer> l, int[] visited){
        if (l.size()==N) {
            int j=0;
            for (j=0; j<l.size(); j++){
                if (l.get(j)%(j+1)==0 || (j+1)%l.get(j)==0) continue;
            }
            if (j==l.size()) count++;
            return;
        }
        for (int i=1; i<=N; i++){
            if (visited[i]==1) continue;
            l.add(i);
            visited[i]=1;
            helper(N, l, visited);
            visited[i]=0;
            l.remove(l.size()-1);
        }
    }
}
