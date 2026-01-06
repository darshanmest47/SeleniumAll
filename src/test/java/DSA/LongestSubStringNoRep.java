package DSA;
import java.util.*;

public class LongestSubStringNoRep {
	public static void main(String[] args) {
		String s = "abbas";
		longestSubStr(s);
	}
	
	public static void  longestSubStr(String s) {
		if(s.isEmpty()) System.out.println("No longest substring exists");
		else {
			Set<Character> set = new HashSet<>();
			int i=0,j=0,len=0,maxlen=0;
			while(i<s.length()) {
				if(set.contains(s.charAt(i))) {
					set.remove(s.charAt(j));
					j++;
				}else {
					set.add(s.charAt(i));
					len = i-j+1;
					maxlen = Math.max(len, maxlen);
					i++;
				}
			}
			
			System.out.println(maxlen);
		}
	}

}
