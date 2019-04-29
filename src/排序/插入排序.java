package ≈≈–Ú;

import java.util.Arrays;

public class ≤Â»Î≈≈–Ú {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[]{6,8,7,4,2,5,3};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]<a[j]){
					int temp=a[i];
					for(int k=i;k>j;k--){
						a[k]=a[k-1];
					}
					a[j]=temp;
					break;
				}
			}
			
			
		}
		System.out.println(Arrays.toString(a));
	}

}
