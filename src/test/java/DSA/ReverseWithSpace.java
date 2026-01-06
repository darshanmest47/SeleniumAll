package DSA;
import java.util.*;

public class ReverseWithSpace {
	public static void main(String[] args) {
		
		String value = "abc de"; // edc ba
		reverseWithSpace(value.trim());
	}
	

	
	public static void reverseWithSpace(String s) {
		if(s.isEmpty()) System.out.println(" ");
		else {
			List<Integer> alist = new ArrayList<>();
			StringBuilder sb =new StringBuilder();
			
			for(int i=s.length()-1;i>=0;i--) {
				if(s.charAt(i)==' ') {
					alist.add(i);
				}else {
					sb.append(s.charAt(i));
				}
			}
			
			
			for(int i=0;i<alist.size();i++) {
				sb.insert(alist.get(i), " ");
			}
			
			System.out.println(sb.toString());
			
			
		}
	}

}
