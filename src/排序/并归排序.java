package ≈≈–Ú;

import java.util.Arrays;

public class ≤¢πÈ≈≈–Ú {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[]{6,8,7,4,2,5,3};
		f(a, 0, a.length-1, new int[a.length]);
		System.out.println(Arrays.toString(a));
	}
	public static void f(int[] a,int left,int right,int[] temp) {
		if(left<right){
			int mid=(left+right)/2;
			f(a, left, mid, temp);
			f(a, mid+1, right, temp);
			margen(a,left,right,mid,temp);
		}
	}
	private static void margen(int[] a, int left, int right, int mid, int[] temp) {
		// TODO Auto-generated method stub
		int i=left,j=mid+1,k=0;
		while(i<=mid&&j<=right){
			if(a[i]<a[j]){
				temp[k++]=a[i];
				i++;
			}else{
				temp[k++]=a[j];
				j++;
			}
		}
		while(i<=mid){
			temp[k++]=a[i++];
		}
		while(j<=right){
			temp[k++]=a[j++];
		}
		k=0;
		while(left<=right){
			a[left++]=temp[k++];
		}
	}
}
