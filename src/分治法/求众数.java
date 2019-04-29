package 分治法;

import javax.swing.text.MaskFormatter;

public class 求众数 {

	public static void main(String[] args) {
		int[] nums=new int[]{2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
	}
	public static int majorityElement(int[] nums) {
        return f(nums, 0, nums.length-1);
    }
	public static int f(int[] nums,int left,int right){
		if(left==right) return nums[left];
		int mid=(left+right)/2;       //分 
		int leftValue=f(nums, left,mid);
		int rightValue=f(nums, mid+1, right);
		
		int leftSum=0;               //治
		int rightSum=0;
		for(int i=left;i<=right;i++){
			if(nums[i]==leftValue) leftSum++;
			if(nums[i]==rightValue) rightSum++;
		}
		if(leftSum>rightSum)
			return leftValue;
		else
			return rightValue;
	}
}
