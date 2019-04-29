package 递归小问题;

public class 取球游戏 {
	static int[] num = new int[] { 1, 3, 7, 8 };
	static boolean flag = false;

	public static void main(String[] args) {
		// for (int i = 1; i < 30; i++) {
		f2(39, 'A');
		System.out.println("i=" + 39 + "" + flag);
		flag = false;
		// }
		for(int i=1;i<=50;i++){
			f2(i,'A');
			System.out.println(flag);
			flag=false;
		}
		
		
	}

	private static void f2(int n, char ch) {
		if (n == 1 && ch == 'B') {
			flag = true;
		}
		for (int a = num.length - 1; a >= 0; a--) {
			if (n - num[a] >= 1) {
//				System.out.println(ch + "拿" + num[a] + "个" + "n有" + n + "个");
				f2(n - num[a], ch == 'A' ? 'B' : 'A');
			}
		}
	}
	static boolean f(int n){
		if(n==0) return true;
		
		if(n>=1 && f(n-1)==false) return true;
		if(n>=3 && f(n-3)==false) return true;
		if(n>=7 && f(n-7)==false) return true;
		if(n>=8 && f(n-8)==false) return true;
		
		return false;
	}
}
