package 动态规划;

import java.util.Scanner;

class Cake {
	public Cake(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public Cake() {
	}

	int w;
	int h;
}

public class 分蛋糕 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(), h = sc.nextInt(), m = sc.nextInt();
		int[][][] dp=new int[w+1][h+1][m+1];

	}

	private static int f(int w, int h, int m) {
		System.out.println(w+"    "+h +"    "+m+"    "+w*h);
		if(w*h<m+1)
			return 999;
		if(m==0) return w*h;
		int min=0;
		
		return  min;
	}
}
