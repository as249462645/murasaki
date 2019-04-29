package 深度优先搜索;

import java.util.Arrays;

/*
 *                 深搜 ------>超时   共42案例   通过40个  
 *                 原课程表I代码   现带给课程表II代码
 *                 解决
 *                 
 */

public class 课程表Ⅱ {
	static int[] canFinish; // 能够完成的科目
	static int[] temp; // 存放学习当前科目所需要的科目
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

		for (int i = 0; i < prerequisites.length; i++) { // 吧需要前提科目的科目做标记
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
			return new int[0]; // 全部需要前置的话无法达成
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
		for (int i = 1; i <= repare[n][0]; i++) { // 查询需要的科目是否全部完成
			if (canFinish[repare[n][i]] == 1) { // 如果没有完成
				for (int j = 0; j < p; j++) { // 检查是否产生环
					if (repare[n][i] == temp[j]) {
						return Integer.MAX_VALUE;
					}
				}
				t[count++] = repare[n][i];
				temp[p++] = repare[n][i]; // 吧n的没有完成的课程放入数组
			}
		}
		int x = 0, b = 0;
		if (count != 0) { // 如果全部完成
			for (int i = 0; i < count; i++) // 对当然科目需要的科目进行遍历
				if ((x = f(t[i], numCourses, prerequisites)) != Integer.MAX_VALUE) {
					b += x;
				}
		}
		count -= b;
		if (count == 0) {
			v[vp++] = n;
			canFinish[n] = 0; // 将此科目完成
			return 1;
		}
		return 0;
	}
}
