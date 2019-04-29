package 深度优先搜索;

import java.util.Arrays;

public class 素数环 {
	static int n;
	static int[] a;
	public static void main(String[] args) {
		n=8;
		a=new int[n];
//		System.out.println(isPrime(317));
		for(int i=1;i<=n;i++){
			a[0]=i;
			dfs(1, a);
		}
	}
	private static void dfs(int k,int[] nums){
		if(k==n){
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i=1;i<=n;i++){
			if(isPrime(nums[k-1]+i)&&haveSome(i, nums)){
				nums[k]=i;
				dfs(k+1, nums);
				nums[k]=0;
			}
		}
			
	}
	public static boolean isPrime(int n){
		if(n==2||n==3) return true;
		if(n%6!=1&&n%6!=5) return false;
		int l=(int) Math.sqrt(n);
		for(int i=5;i<l;i+=6)
			if(n%i==0||n%(i+2)==0) return false;
		return true;
	}
	public static boolean haveSome(int k,int[] nums){
		for(int i=0;i<n;i++){
			if(nums[i]==k) return false;
		}
		return true;
	}
}
