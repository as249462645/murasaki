package 动态规划;

import java.util.Scanner;

class board {
	int left;
	int right;
	int height;
}

public class HelpJimmy {
	static int n, x, y, max;
	static board[] data;
	static int minM;
	static int[][] leftMinTime;
	static int[][] rightMinTime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		max = sc.nextInt();
		data = new board[n + 1];
		int maxHeight = 0;
		int maxRight = 0;
		for (int i = 0; i < n; i++) {
			data[i] = new board();
			data[i].left = sc.nextInt();
			data[i].right = sc.nextInt();
			data[i].height = sc.nextInt();
			if (data[i].right > maxRight)
				maxRight = data[i].right;
			
		}
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1; j++) {
				if (data[j].height < data[i].height) {
					board temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		data[data.length - 1] = new board();
		data[data.length - 1].height = 0;
		data[data.length - 1].left = 0;
		data[data.length - 1].right = Integer.MAX_VALUE;
		leftMinTime=new int[n+1][10000];
		rightMinTime=new int[n+1][10000];
		// System.out.println(data.length);
		// for(int i=0;i<data.length;i++)
		// System.out.println(data[i].height);
		System.out.println(f(0, y, x, 0));
	}

	private static int f(int m, int i, int j, int p) {
		int k;
		for (k = p; k < data.length; k++) {
			if (j >= data[k].left && j <= data[k].right) {
				if (i - data[k].height >= max){   //判断是否摔死
					return Integer.MAX_VALUE;
				}
				else                             //安全着落
					m += i - data[k].height;
				break;
			}
		}
		
		if (k == n){  //到处最后一块板子（地面）
			System.out.println("board="+k+"    m="+m);
			return m;
		}
		// System.out.println(p);
		if(leftMinTime[p][m]==0)
			leftMinTime[p][m]= f(m + j - data[k].left, data[k].height, data[k].left, k + 1);  //左走
		else return leftMinTime[p][m];
		if(rightMinTime[p][m]==0)
			rightMinTime[p][m] = f(m + data[k].right - j,data[k].height, data[k].right, k + 1); //右走
		else return rightMinTime[p][m];
		return Math.min(leftMinTime[p][m], rightMinTime[p][m]);
	}
}
