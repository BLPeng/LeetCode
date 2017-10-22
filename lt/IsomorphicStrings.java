import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class IsomorphicStrings {
	
	public boolean isTsomorphic(String s, String t){
		if (s==null || t==null || s.length()<=1 || t.length()<=1) return true;
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		for (int i=0; i<s.length(); i++){
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (hm.containsKey(a)){
				if (hm.get(a).equals(b)){
					continue;
				} else return false;
			} else {
				if (hm.containsValue(b)){
					return false;
				} else {
					hm.put(a, b);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "12345";
		String t = "apple";
		String i = "akoop";
        IsomorphicStrings is = new IsomorphicStrings();
        //System.out.println(is.isTsomorphic(s, t));
        //System.out.println(is.isTsomorphic(s, i));
		char[] c= {'a','s','d','f','g'};
		System.out.println(c.toString());
//		char[] c1 = new char[c.length];
//		for (int j=0; j<c.length; j++){
//			c1[j] = c[j];
//		}
//		Arrays.sort(c);
//		System.out.println(c);
//		System.out.println(c1);
//        List l = new ArrayList();
//        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//        int[] bucket = new int[26];
//        //char[] c1 = c;
//        Arrays.sort(c);
//        //System.out.println(c1);
//        //System.out.println(c);
//        String s = "hello";
//        char[] c1 = s.toCharArray();
//        char[] c2 = s.toCharArray();
//        Arrays.sort(c1);
//        Arrays.sort(c2);
//        System.out.println(c1);
//        System.out.println(c2);
//        List<Character>[] array = new List [25];
//        System.out.println(array.length);
//        System.out.println(Arrays.equals(c1, c2));
//        //int a = 100;
//        int[] a = new int[25];
//        boolean [] isPrime = new boolean[100];
//        System.out.println(isPrime[9]);
//        Stack s2 = new Stack();
//        StringBuilder sb = new StringBuilder();
//        sb.deleteCharAt(sb.length()-1);
        
	}

}
