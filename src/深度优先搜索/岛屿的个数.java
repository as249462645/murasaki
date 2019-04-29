package 深度优先搜索;

import java.util.Scanner;

public class 岛屿的个数 {
	static int[][] map;
	static boolean[][] flag;
	static int[][] f=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		map=new int[4][5];
		flag=new boolean[4][5];
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				map[i][j]=sc.nextInt();
			}
		}
		int num=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++){
				if(map[i][j]==1){
					f(i, j);
					num++;
				}
			}
		}
		System.out.println(num);
		util.Util.printArray(map);
		
	}
	private static void f(int i,int j){
		System.out.println(i+"          "+j);
		if(i<0|i>3|j<0|j>4) return;
		if(flag[i][j]||map[i][j]==0) return;
		flag[i][j]=true;
		map[i][j]=2;
		for(int k=0;k<4;k++){
			f(i+f[k][0],j+f[k][1]);
		}
	}

}
