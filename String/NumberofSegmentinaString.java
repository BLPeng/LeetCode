package String;
//Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
//Please note that the string does not contain any non-printable characters.
//
//Example:
//
//Input: "Hello, my name is John"
//Output: 5
public class NumberofSegmentinaString {
	public int countSegments(String s) {
        String s1 = s.trim();
        if (s1==null) return 0;
        String[] result = s1.split("\\s+");
        return result.length;
    }
}
