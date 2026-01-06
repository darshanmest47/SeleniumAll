package DSA;

public class SecondLargestinArray {
	public static void main(String[] args) {
//		int nums[] = {1,49,2,100,54};
		int nums[] = {1,2,3,4,5};
		secondLargest(nums);
	}
	
	public static void secondLargest(int[] nums) {
		if(nums.length==0) {System.out.println("No Second Largest exists");}
		else {
			int first =0,second=0;
			if(nums[0]>nums[1]) {
				first = nums[0];
				second = nums[1];
			}else {
				first = nums[1];
				second=nums[0];
			}
			
			for(int i=2;i<nums.length;i++) {
				if(nums[i]>first) {
					second = first;
					first = nums[i];
				}else if(nums[i]>second && nums[i]<first) {
					second = nums[i];
				}
			}
			
            System.out.println("Second largest is "+second);			
		}
	}

}
