package 深度优先搜索;

public class 部分和 {
	static int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
	static int n = 4;
	static int k = 10;

	public static void main(String[] args) {
		f(0, "0", 0);
	}

	private static void f(int n, String str, int sum) {
		if (sum == k) {
			System.out.println(str);
			return;
		}
		if(n==nums.length) return;
		f(n + 1, str + "+" + nums[n], sum + nums[n]);
		f(n + 1, str, sum);
	}
}
