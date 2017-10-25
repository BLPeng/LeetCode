package String;
//You are given a string representing an attendance record for a student. The record only contains the following three characters:
//
//'A' : Absent.
//'L' : Late.
//'P' : Present.
//A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
//
//You need to return whether the student could be rewarded according to his attendance record.
//
//Example 1:
//Input: "PPALLP"
//Output: True
//Example 2:
//Input: "PPALLL"
//Output: False
public class StudentAttendanceRecord {
	public boolean checkRecord(String s) {
        int[] frequency = new int[26];
        int count=1;
        for (int i=0; i<s.length(); i++){
            frequency[s.charAt(i)-'A']++;
            if (frequency[0]>1) return false;
            if (i>0 && s.charAt(i)==s.charAt(i-1) && s.charAt(i-1)=='L') {
                count++;
                if (count>2) return false;
            }
            if (i>0 && s.charAt(i-1)=='L' && s.charAt(i)!='L') count=1;
        }
        return true;
    }
}
