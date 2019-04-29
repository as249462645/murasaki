package util;

public class Util {
	
	public static void printArray(int[][] a){
		for(int[] b:a){
			for(int n:b){
				System.out.print(n+"\t");
			}
			System.out.println();
		}
	}
	public static void printArray(char[][] a){
		for(char[] b:a){
			for(char n:b){
				System.out.print(n+"\t");
			}
			System.out.println();
		}
	}
}
