package DSA;
import java.util.*;

public class LongestConsecutive {
	
	public static void main(String[] args) {
		int nums[] = {1,0,1,2};
		System.out.println(longestSequence(nums));
	}
	
	public static int longestSequence(int nums[]) {
		if(nums.length==0) return 0;
		else {
			int longestConsecutive=0;
			Set<Integer> set =new HashSet<>();
			for(int num :nums) {
				set.add(num);
			}
			
            for(int num : set) {
            	if(!set.contains(num-1)) {
            		int value = num;
            		int consecutive = 1;
            		
            	   while(set.contains(value+1)) {
            		   value = value+1;
            		   consecutive++;
            	   }
            	   
            	   longestConsecutive = Math.max(consecutive, longestConsecutive);
            	}
            }
			return longestConsecutive;
		}
		
	}

}
