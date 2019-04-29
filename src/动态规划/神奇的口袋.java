package 动态规划;

import java.util.Scanner;

public class 神奇的口袋 {
	static int V=40,n;
	static int[] stuff;
	static int[][] DP;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		DP=new int[300][300];
		stuff=new int[n+1];
		for(int i=0;i<n;i++){
			stuff[i]=sc.nextInt();
		}
		long mutil=System.currentTimeMillis();
		System.out.println(DFS(0, 0));
		System.out.println(System.currentTimeMillis()-mutil+"ms");
	}
	private static int DFS(int k,int v){
//		if(DP[k][v]!=0) return DP[k][v]; 
		if(v==V)
			return 1;
		if(k>=n||v>V) 
			return 0;
		DP[k][v]=DFS(k+1, v)+DFS(k+1, v+stuff[k]);
		return DP[k][v];
	}
	private static int DP(){
		DP[0][0]=1;
		for(int i=1;i<=40;i++){
			for(int j=1;j<=n;j++){
				DP[i][j]=DP[i][j-1];
				if(i-stuff[j]>=0)
					DP[i][j]+=DP[i-stuff[j]][j-1];
			}
		}
		return DP[40][n];
	}
	
}
