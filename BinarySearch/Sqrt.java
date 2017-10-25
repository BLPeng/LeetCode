package BinarySearch;
//Implement int sqrt(int x).
public class Sqrt {
	public int mySqrt(int x) {
        if (x<0) return x;
        if (x==0) return 0;
        int start=1, end=x;
        while (true){
            int mid = start + (end-start)/2;
            if (mid>x/mid) end = mid-1;
            else {
                if ((mid+1)>x/(mid+1)) return mid;
                start = mid+1;
            }
        }
    }
}
