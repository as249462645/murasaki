package 深度优先搜索;

import java.util.Arrays;

public class 困难的串 {
	static String[] letter = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
	static int n, l;
	static String[] v;

	public static void main(String[] args) {
		n = 6;
		l = 3;
		v = new String[n + 1];
		DFS(1);
//		System.out.println("ABACABCACBABCABACABCACBACABA".equals("ABACABCACBABCABACABCACBACABA"));
	}

	private static void DFS(int k) {
		if (k == n + 1) {
			for(int i=1;i<=n;i++){
				System.out.print(v[i]);
			}
			System.out.println();
//			System.exit(0);;
			return;
		}
		for (int i = 0; i < l; i++) {
			v[k] = letter[i];
			if (isCode(v, k))
				DFS(k + 1);
		}
	}

	private static boolean isCode(String[] ch, int k) {
		int l = 1;
		for (int i = 0; i < k / 2; i++) {
			String str1 = "", str2 = "";
			int n = k;
			for (int j = 0; j < l; j++, n--) {
				str1 += ch[n];
			}
			for (int j = 0; j < l; j++, n--) {
				str2 += ch[n];
			}
			if (str1.equals(str2))
				return false;
			l++;
		}
		return true;
	}

}
