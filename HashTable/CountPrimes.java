package HashTable;
//Count the number of prime numbers less than a non-negative number, n.
public class CountPrimes {
	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n]; //初始化默认为false；
        int count = 0;
        for (int i=2; i<n; i++){
            if (notPrime[i]==false){
                count ++;
                for (int k=2; k*i<n; k++){
                    notPrime[i*k] = true;
                }
            }
        }
        return count;
    }
}
