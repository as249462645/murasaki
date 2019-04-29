package 二分算法;

public class 二分查找 {

	public static void main(String[] args) {
		int[] a=new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println(search(a, 6, 0, a.length-1));
	}
	private static int search(int []a,int p,int left,int right){
		if(left>right) return -1;
		int mid=(left+right)/2;
		if(p>a[mid])
			return search(a,p, mid+1, right);
		else if(p<a[mid])
			return search(a,p, left, mid);
		else if(p==a[mid])
			return mid;
		else
			return -1;
	}
}
