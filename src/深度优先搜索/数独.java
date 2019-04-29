package 深度优先搜索;

import util.Util;

public class 数独 {
	static int[][] a;
	static boolean[][] v;

	public static void main(String[] args) {
		a = new int[9][9];
		v = new boolean[9][9];
		f(0, 0);
	}

	public static void f(int i, int j) {
		if(i==9){
			Util.printArray(a);
			System.out.println();
			return;
		}
		if(a[i][j]!=0) return;
		boolean flag;
		for(int k=1;k<=9;k++){
			a[i][j]=k;
			flag=true;
			for(int n=0;n<9;n++){
				if((n!=j&&a[i][n]==a[i][j])||(n!=i&&a[n][j]==a[i][j])){
					flag=false;
					break;
				}
			}
			if(flag){
				f(i+(j+1)/9, (j+1)%9);
			}
		}
		a[i][j]=0;
	}
}
