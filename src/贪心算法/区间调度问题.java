package 贪心算法;

public class 区间调度问题 {

	public static void main(String[] args) {
		int n = 5;
		int[] start = new int[] { 0, 1, 2, 4, 6, 8, 0 };
		int[] end = new int[] { 0, 3, 5, 7, 9, 10, 999 };
		int s1, s2;
		int crruntTime = 0;
		int num = 0;
		for (int i = 1; i < n; i++) {
			if (crruntTime < start[i]) {
				s1 = end[i] - start[i];
				s2 = start[i + 1] - start[i] + end[i + 1] - start[i - 1];
				if (s1 < s2) {
					crruntTime = end[i];
				} else {
					crruntTime = end[i + 1];
				}
				num++;
			}
		}
		System.out.println(num);
	}

}
