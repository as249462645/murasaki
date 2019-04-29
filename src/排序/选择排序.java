package ≈≈–Ú;

import java.util.Arrays;

public class —°‘Ò≈≈–Ú {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 6, 8, 7, 4, 2, 5, 3 };
		int temp, k = 0;
		for (int i = 0; i < a.length; i++) {
			temp = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (temp < a[j]) {
					temp = a[j];
					k = j;
				}
			}
			if (k != 0) {
				a[k] = a[i];
				a[i] = temp;
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
