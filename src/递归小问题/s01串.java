package µ›πÈ–°Œ Ã‚;

import java.util.Scanner;

public class s01¥Æ {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(f(n));
	}
	private static String f(int n){
		if(n==0) return "0";
		if(n==1) return "1";
		return f(n-2)+f(n-1);
	}

}
