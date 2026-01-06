package DSA;

public class ReverseLastWord1 {
	public static void main(String[] args) {
		String s = "I Love Java Programming";  //I Love Java gnimmargorP 
		reverseLast(s.trim());
	}
	
	public static void reverseLast(String s) {
		if(s.isEmpty()) {
			System.out.println("");
		}else {
			String splitString[] = s.split(" ");
			StringBuilder sb = new StringBuilder();
			String last = splitString[splitString.length-1];
			
			for(int i=last.length()-1;i>=0;i--) {
				sb.append(last.charAt(i));
			}
			
			splitString[splitString.length-1] = sb.toString();
			sb.delete(0, sb.length());
			for(String str : splitString) {
				sb.append(str).append(" ");
			}
			
			System.out.println(sb.toString());
		}
	}

}
