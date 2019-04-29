package 二分算法;

public class 搜索二维矩阵 {

	public static void main(String[] args) {
		int[][] a = new int[][] { {1},{1} };
		System.out.println(searchMatrix(a,0));
//		System.out.println(a[0].length);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0||matrix[0].length==0)
			return false;
		return searchMatrix(matrix, target, matrix.length - 1,0);
	}

	public static boolean searchMatrix(int[][] matrix, int target, int i, int j) {
		System.out.println(i+"     "+j);
		if (j == -1 || i == matrix.length)
			return false;
		if (target > matrix[i][j]){
			if(i+1==matrix[i].length) return false;
			return searchMatrix(matrix, target, i, j+1);
		}
		else if (target < matrix[i][j]){
			if(matrix[i].length-1==i) return false;
			return searchMatrix(matrix, target, i-1, j);
		}
		else
			return true;
	}
}