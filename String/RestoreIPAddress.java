package String;

import java.util.ArrayList;
import java.util.List;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> l = new ArrayList<String>();
        for (int i=1; i<4&&i<s.length()-2; i++){
            for (int j=i+1; j<i+4&&j<s.length()-1; j++){
                for (int k=j+1; k<j+4&&k<s.length(); k++){
                    String s1=s.substring(0,i), s2=s.substring(i,j), s3=s.substring(j,k), s4=s.substring(k,s.length());
                    if (helper(s1)&&helper(s2)&&helper(s3)&&helper(s4)) l.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }
        return l;
    }
    public boolean helper(String s){
        if (s.length()>3 || s.length()==0 || (s.length()>1 && s.charAt(0)=='0') || Integer.parseInt(s)>255) return false;
        return true;
    }
}
