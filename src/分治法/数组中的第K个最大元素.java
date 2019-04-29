package 分治法;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 数组中的第K个最大元素 {

	public static void main(String[] args) {
		int[] a=new int[]{7,2,4,5,4,9};
		System.out.println(queque(a,4));
	}
	public static int findKthLargest(int[] nums, int k) {   
        return f(nums, 0, nums.length-1, k-1);
    }
	public static int f(int[] nums,int left,int right,int k){  //快排二分思想
		if (left >= right) {
			return nums[k];
		}
		int i=left;
		int j=right;
		int num=nums[left];
		while(i<j){
			while(i<j&&nums[j]<=num)
				j--;
			if(i<j) nums[i]=nums[j];
			while(i<j&&nums[i]>=num)
				i++;
			if(i<j) nums[j]=nums[i];
		}
		nums[i]=num;
		if(i<k)
			return f(nums,  i+1, right, k);
		else if(i>k)
			return f(nums, left, i-1, k);
		else
			return nums[i];
	}
	public static int queque(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i=0;i<nums.length;i++){
            if (pq.size() < k){
                pq.offer(nums[i]);
            }else {
                if (nums[i] > pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
            System.out.println(pq.toString());
        }
        
        return pq.peek();
    }
}
