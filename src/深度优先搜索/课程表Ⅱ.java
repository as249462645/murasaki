package �����������;

import java.util.Arrays;

/*
 *                 ���� ------>��ʱ   ��42����   ͨ��40��  
 *                 ԭ�γ̱�I����   �ִ����γ̱�II����
 *                 ���
 *                 
 */

public class �γ̱�� {
	static int[] canFinish; // �ܹ���ɵĿ�Ŀ
	static int[] temp; // ���ѧϰ��ǰ��Ŀ����Ҫ�Ŀ�Ŀ
	static int p;
	static int[][] repare;
	static int[] v;
	static int vp;

	public static void main(String[] args) {
//		 int[][] a = new int[][] { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, {
//		 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } };
		int[][] a = new int[][] { { 1, 0   }, { 1, 2 }, { 0, 1 } };
		System.out.println(Arrays.toString(findOrder(7, a)));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		canFinish = new int[numCourses];
		temp = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) { // ����Ҫǰ���Ŀ�Ŀ�Ŀ�����
			canFinish[prerequisites[i][0]] = 1;
		}

		repare = new int[numCourses + 1][numCourses + 1];

		for (int i = 0; i < prerequisites.length; i++) {
			repare[prerequisites[i][0]][++repare[prerequisites[i][0]][0]] = prerequisites[i][1];
		}
		vp = 0;
		v = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (canFinish[i] == 0)
				v[vp++] = i;
		}

		if (vp == 0)
			return new int[0]; // ȫ����Ҫǰ�õĻ��޷����
		for (int i = 0; i < numCourses; i++) {
			p = 0;
			if (canFinish[i] == 1)
				f(i, numCourses, prerequisites);
		}
		if (vp   ==  numCourses){
			return v;
		}
		else
			return new int[0];
	}

	private static int f(int n, int numCourses, int[][] prerequisites) {
		int count = 0;
		int[] t = new int[numCourses];
		for (int i = 1; i <= repare[n][0]; i++) { // ��ѯ��Ҫ�Ŀ�Ŀ�Ƿ�ȫ�����
			if (canFinish[repare[n][i]] == 1) { // ���û�����
				for (int j = 0; j < p; j++) { // ����Ƿ������
					if (repare[n][i] == temp[j]) {
						return Integer.MAX_VALUE;
					}
				}
				t[count++] = repare[n][i];
				temp[p++] = repare[n][i]; // ��n��û����ɵĿγ̷�������
			}
		}
		int x = 0, b = 0;
		if (count != 0) { // ���ȫ�����
			for (int i = 0; i < count; i++) // �Ե�Ȼ��Ŀ��Ҫ�Ŀ�Ŀ���б���
				if ((x = f(t[i], numCourses, prerequisites)) != Integer.MAX_VALUE) {
					b += x;
				}
		}
		count -= b;
		if (count == 0) {
			v[vp++] = n;
			canFinish[n] = 0; // ���˿�Ŀ���
			return 1;
		}
		return 0;
	}
}
