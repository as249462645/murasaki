package �ݹ�С����;

import java.util.Scanner;

public class m������ȡn�����ж�����ȡ�� {
	public static int f(int m,int n){
		if(m==n) return 1;
		if(m==0) return 0;
		if(n==0) return 1;
		return f(m-1,n-1)+f(m-1,n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println(f(m, n));;
	}

}
