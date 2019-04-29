package ÅÅÐò;

import java.util.Arrays;

public class ¿ìËÙÅÅÐò {

	public static void main(String[] args) {
		int[] a = new int[] { 3123,4, 9, 1, 4, 5, 6, 8, 7, 4, 5, 2, 4984, 48, 784, 1, 61, 66, 1, 165 };
		f(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private static void f(int[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int temp = a[left];
		int i = left, j = right;
		while (i < j) {
			while (a[j] >= temp && i < j)
				j--;
			if (i < j)
				a[i] = a[j];
			while (a[i] <= temp && i < j)
				i++;
			if (i < j)
				a[j] = a[i];
		}
		a[i] = temp;
		f(a, left, i-1);
		f(a, i + 1, right);
	}
}
