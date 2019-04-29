package 分治法;

public class 最大子序和 {
	public static void main(String[] args) {
		int[] a=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(a));
	}
	public static int maxSubArray(int[] nums) {
		
        return maxSubArrayTow(nums,0,nums.length-1);
	}
	public static int maxSubArrayTow(int[] nums,int left,int right){
		if(right==left){
			if(nums[left]>0) return nums[left];
			else return 0;	
		} 
		int mid=(left+right)/2;
		int leftMax=maxSubArrayTow(nums, left, mid);
		int rightMax=maxSubArrayTow(nums, mid+1, right);
		
		int leftMaxValue=0,leftTemp=0;
		for(int i=mid;i>=left;i--){
//			System.out.print(nums[i]+" "); 
			leftTemp+=nums[i];
			if(leftMaxValue<leftTemp)
				leftMaxValue=leftTemp;
		}
//		System.out.println();
//		System.out.println("左："+left+"  右"+mid +"  最大数："+leftMax);
		int rightMaxValue=0,rightTemp=0 ;
		for(int i=mid+1;i<=right;i++){
//			System.out.print(nums[i]+" ");
			rightTemp+=nums[i];
			if(rightMaxValue<rightTemp)
				rightMaxValue=rightTemp;
		}
//		System.out.println();
//		System.out.println("左："+(mid+1)+"  右"+right+"   最大数："+rightMax);
//		System.out.println();System.out.println();
//		System.out.println(left+"     "+right+"  "+leftMaxValue+"     "+rightMaxValue);
		return max3(rightMaxValue+leftMaxValue,leftMax,rightMax);
	}
	public static int max3(int n1,int n2,int n3){
		return Math.max(Math.max(n1, n2), Math.max(n2, n3));
	}
}
