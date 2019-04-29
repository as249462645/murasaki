package 分治法;

import java.util.Arrays;

public class 归并排序 {

	public static void main(String[] args) {
		int[] a=new int[]{6,5,4,3,2,1};
		fen(a, 0, a.length-1, new int[a.length]);
		System.out.println(Arrays.toString(a));
	}

	public static void fen(int a[], int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			fen(a, left, mid, temp);
			fen(a, mid+1 , right, temp);
			mergin(a, left,mid,right, temp);
		}
	}

	public static void mergin(int[] a, int left, int mid,int right, int[] temp) {
		int p1=left,p2=mid+1,p=0;
		while(p1<=mid&&p2<=right){
			if(a[p1]<=a[p2])
				temp[p++]=a[p1++];
			else 
				temp[p++]=a[p2++];
		}
		while(p1<=mid)
			temp[p++]=a[p1++];
		
		while(p2<=right)
			temp[p++]=a[p2++];
		p=0;
		System.out.println(" left="+left+"  mid="+mid+"  right="+right);
		while(left<=right){
			System.out.print(temp[p]+"   ");
			a[left++]=temp[p++];
		}
		System.out.println();
//		System.out.println(Arrays.toString(a)+" left"+left+"   right"+right);
	}
}
