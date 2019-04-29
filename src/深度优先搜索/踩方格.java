package 深度优先搜索;

import java.util.Scanner;

public class 踩方格 {
	static int[][] a=new int[100][100];
	static int[][] flag=new int[100][100];
	static int[][] f=new int[][]{{1,0},{0,1},{0,-1}};
	static int n;
	static int count=0;
	public static void main(String[] args) {
		n=new Scanner(System.in).nextInt();
		f(50, 50, 0);
		System.out.println(count);
		
	}
	private static void f(int i,int j,int k){
		if(flag[i][j]==1) return;
		if(n==k){
			count++;
			return;
		}
		k+=1;
		for(int k1=0;k1<3;k1++){
			flag[i][j]=1;
			f(i+f[k1][0], j+f[k1][1],k);
			flag[i][j]=0;
		}
	}

}
