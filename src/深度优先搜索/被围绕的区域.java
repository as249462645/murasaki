package 深度优先搜索;

import util.Util;

public class 被围绕的区域 {
	static int[][] fx = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	public static void main(String[] args) {
		char[][] ch=new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		solve(ch);
	}

	public static void solve(char[][] board) {
		if(board.length==0) return ;
		int m=board.length-1,n=board[0].length-1;
		for(int i=0;i<=m;i++){
			if(board[i][0]=='O')
				f(i, 0, board);
			if(board[i][n]=='O')
				f(i, n, board);
		}
		for(int i=0;i<=n;i++){
			if(board[0][i]=='O')
				f(0, i, board);
			if(board[m][i]=='O')
				f(m, i, board);
		}
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(board[i][j]=='O')
					board[i][j]='X';
				if(board[i][j]=='h')
					board[i][j]='O';
			}
		}
		Util.printArray(board);
	}

	private static void f(int i, int j, char[][] board) {
		board[i][j] = 'h';
		for (int k = 0; k < 4; k++) {
			i += fx[k][0];
			j += fx[k][1];
			if(i>=0&&i<board.length&&j>=0&&j<board[0].length){
				if(board[i][j]=='O')
					f(i, j, board);
			}
			i -= fx[k][0];
			j -= fx[k][1];
			
			
		}
	}
}
