package DSA;
import java.util.*;

public class LongestConsecvutive {
     public static void main(String[] args) {
		int[] nums = {1,0,1,2};
		longestConsecutive(nums);
	}
     
     public static void longestConsecutive(int[] nums) {
    	 if(nums.length==0) System.out.println(0);
    	 else {
    		 Set<Integer> hs = new HashSet<>();
    		 int longestSequence = 0;
    		 for(int num : nums) {
    			 hs.add(num);
    		 }
    		 
    	     for(int num : hs) {
    	    	 if(!hs.contains(num-1)) {
    	    		 int currentNum = num;
    	    		 int currentSequence = 1;
    	    		 
    	    		 while(hs.contains(currentNum+1)) {
    	    			 currentNum = currentNum+1;
    	    			 currentSequence++;
    	    		 }
    	    		 longestSequence = Math.max(currentSequence, longestSequence);
    	    	 }
    	     }
    	     System.out.println("Longest subsquence is "+longestSequence);
    	 }
    	 
     }
}
