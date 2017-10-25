package BinarySearch;
//Implement pow(x, n).
public class Pow {
	public double myPow(double x, int n) {
        if (n<0) return 1/pow(x, -n);
        else return pow(x, n);
    }
    public double pow(double x, int n){
        if (n==0) return 1;
        double half = pow(x, n/2);
        if (n%2==0) return half*half;
        else return x*half*half;
    }
}
