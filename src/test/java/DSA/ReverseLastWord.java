package DSA;
import java.util.*;
public class ReverseLastWord {
	public static void main(String[] args) {
		String[] vals = {"abcd","bcad","klem"};
		reverseLastWord(vals);
	}
	
	public static void reverseLastWord(String[] vals) {
		if(vals.length==0) System.out.println("No value exists in array");
		else {
			String[] newArr = new String[vals.length];
			int i=0;
			while(i<vals.length-1) {
				newArr[i] = vals[i];
				i++;
			}
			
			String[] splitArray = vals[i].split("");
			StringBuilder sb = new StringBuilder();
			for(int j=splitArray.length-1;j>=0;j--) {
				sb.append(splitArray[j]);
			}
						
			newArr[i] = sb.toString();
			
			for(String s : newArr) {
				System.out.println(s);
			}
			
			
			
		}
	}

}
