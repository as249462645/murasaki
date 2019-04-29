package 二分算法;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class 整数对 {

	public static void main(String[] args) {
		int[] a=new int[]{1,2,3,4,5,6,7,8,9};
		f(10,0,a.length-1, a);
	}
	private static void f(int p,int left,int right,int[] a){
		if(a[left]+a[right]<p)
			f(p, left+1, right, a);
		if(a[left]+a[right]>p)
			f(p, left, right-1, a);
		else 
			System.out.println(a[left]+"      "+a[right]);
	}

}
