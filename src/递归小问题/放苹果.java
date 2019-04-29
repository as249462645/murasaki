package 递归小问题;

import java.util.Scanner;

public class 放苹果 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		int t=sc.nextInt();
//		int m=sc.nextInt(),n=sc.nextInt();
//		int ma[]=new int[t];
//		int na[]=new int[t];
//		for(int i=0;i<t;i++){
//			ma[i]=sc.nextInt();
//			na[i]=sc.nextInt();
//		}
		System.out.println(f(7, 3));
	}
	private static int f(int m,int n){
		if(n>m) return f(m, m);
		if(m==0) return 1;
		if(n==0) return 0;
		return f(m, n-1)+f(m-n, n);
	}

}
