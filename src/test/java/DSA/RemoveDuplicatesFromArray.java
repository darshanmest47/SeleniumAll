package DSA;
import java.util.*;

public class RemoveDuplicatesFromArray {
	public static void main(String[] args) {
		int[] nums = {1,2,1,3,4,3,5};
		removingDuplicates(nums);
	}
	
	public static void removingDuplicates(int[] nums) {
		if(nums.length==0) {
			System.out.println("No duplicates exist");
		}else {
			List<Integer> alist = new ArrayList<>();
			for(int i=0;i<nums.length;i++) {
				boolean isDuplicate = false;
				for(int j=0;j<alist.size();j++) {
					if(nums[i]==alist.get(j)) {
						isDuplicate=true;
						break;
					}
				}
				
				if(!isDuplicate) {
					alist.add(nums[i]);
				}
				
			}
			
			int[] nonDuplicateArray = new int[alist.size()];
			for(int i=0;i<alist.size();i++) {
				nonDuplicateArray[i] = alist.get(i);
			}
			
			for(int num : nonDuplicateArray) {
				System.out.println(num);
			}
		}
	}

}
