package ¶¯Ì¬¹æ»®;

import java.util.Random;
import java.util.Scanner;

import util.Util;

public class »¬Ñ© {
	static int max;
	static int[][] map;
	static int[][] f=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
	static int m,n;
	static int[][] D;
	static boolean[][] flag;
	public static void main(String[] args) {
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		map=new int[m+2][n+2];
		D=new int[m+2][n+2];
		flag=new boolean[m+2][n+2];
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<=n;i++){
			map[0][i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<=m;i++){
			map[i][0]=Integer.MAX_VALUE;
		}
		max=0;
		long mutil=System.currentTimeMillis();
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				D[i][j]=f(i, j, 0);
				max=Math.max(max,D[i][j]);
			}
		}
		Util.printArray(D);
		System.out.println(max);
		System.out.println(System.currentTimeMillis()-mutil+"ms");
	}
	private static int f(int i,int j,int len){
		if(flag[i][j]) return len;
		if(D[i][j]!=0) return D[i][j]+ len;
		int h=map[i][j],max=0;
		flag[i][j]=true;
		for(int k=0;k<4;k++){
			i+=f[k][0];
			j+=f[k][1];
			if(i>0&&j>0&&i<=m&&j<=n&&h>map[i][j]){
				max=Math.max(max, f(i,j,len+1));
				i-=f[k][0];
				j-=f[k][1];
			}else{
				i-=f[k][0];
				j-=f[k][1];
			}
			
		}
		flag[i][j]=false;
		max=Math.max(max, len);
		return max;
	}
	
	private static int f(){
		int max=0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				for(int k=0;k<4;k++){
					if(map[i][j]>map[i+f[k][0]][j+f[k][1]])
						D[i][j]=Math.max(D[i][j]+1, D[i+f[k][0]][j+f[k][1]]+1);
				}
				max=Math.max(max, D[i][j]);
			}
		}
		
		Util.printArray(D);
		return max;
	}
}
