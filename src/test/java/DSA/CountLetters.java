package DSA;
import java.util.*;

public class CountLetters {
	
	public static void main(String[] args) {
		String s = "DaRsHaN";
		countLetters(s.trim().toLowerCase());
		
	}
	
	public static void countLetters(String s) {
		if(s.isEmpty()) System.out.println(0);
		else {
			Map<Character,Integer> mp = new HashMap<>();
			
			for(char c: s.toCharArray()) {
				if(mp.containsKey(c)) {
					mp.put(c, mp.get(c)+1);
				}else {
					mp.put(c, 1);
				}
			}
			
			System.out.println(mp);
		}
	}

}
