package DSA;

public class LongestPalindromicSub {
	public static void main(String[] args) {
		String s = "abba";
		longestSubString(s);
	}
	
	
	public static void longestSubString(String s) {
		if(s.isEmpty()) System.out.println("No longest substring exists");
		else if(s.length()==1) System.out.println(s);
		else {
			int start =0,end=0,maxLen=0;
			
			for(int i=0;i<s.length();i++) {
				int len1 = expandFromMiddle(s,i,i);
				int len2 = expandFromMiddle(s,i,i+1);
				maxLen = Math.max(len1, len2);
				
				
				if(maxLen > end-start) {
					start = i-((maxLen-1)/2);
					end = i+(maxLen/2);
				}
			}
			
			System.out.println(s.substring(start, end+1));
		}
	}
	
	
	
	public static int expandFromMiddle(String s , int start , int end) {
		if(s.length()==0) return 0;
		else {
			while(start>=0 && end<s.length() && (s.charAt(start) == s.charAt(end))) {
				start--;
				end++;
			}
			
			return end-start-1;
		}
		
	}

}
