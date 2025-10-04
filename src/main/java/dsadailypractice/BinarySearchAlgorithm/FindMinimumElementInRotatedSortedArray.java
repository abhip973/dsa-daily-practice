class FindMinimumElementInRotatedSortedArray {

	public static void main(String[] args){
		System.out.println(findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
	}

	public static int findMin(int[] nums){
		int l = 0;
		int r = nums.length-1;
		int m = 0;
		while(l<r){
			m = l + (r-l)/2;
			if(nums[m] > nums[r]){
				l = m+1;	
			} else {
				r = m;
			}
		}	
		return nums[l];
	}
}