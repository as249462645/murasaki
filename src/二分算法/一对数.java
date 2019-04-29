package 二分算法;

import java.util.Arrays;
import java.util.Random;

public class 一对数 {
	static int[] a;
	static int m;
	public static void main(String[] args) {
		Random rd = new Random();
		a = new int[100];
		for (int i = 0; i < a.length; i++) {
			a[i] = rd.nextInt(100);
		}
		m = rd.nextInt(100);
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("m的值是："+m);
		f(0, a.length-1);
	}

	public static void f(int i, int j) {
		if(i==j) return;
		if(a[i]+a[j]==m) System.out.println(a[i]+"+"+a[j]);
		if(a[i]+a[j]>m) f(i, j-1);
		if(a[i]+a[j]<m) f(i+1, j);
	}
}
