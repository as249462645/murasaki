package 二分算法;

import java.util.Arrays;

public class 寻找两个有序数组的中位数 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 5, 6, 12, 15, 20 };
		int[] b = new int[] { 2, 8, 19, 21, 30 };
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] a = new int[nums1.length + nums2.length];
		int index1 = 0, index2 = 0, index = 0, zhong = (nums1.length + nums2.length) / 2;
		for (int i = 0; i <= zhong; i++) {
			if (index1 == nums1.length) {
				a[index++] = nums2[index2++];
			} else if (index2 == nums2.length)
				a[index++] = nums1[index1++];
			else {
				if (nums1[index1] < nums2[index2])
					a[index++] = nums1[index1++];
				else
					a[index++] = nums2[index2++];
			}
		}
		if((nums1.length+nums2.length)%2==0)
			return (a[zhong] * 1.0 + a[zhong - 1] * 1.0) / 2;
		else{
			return a[zhong] * 1.0;
		}
	}
}
