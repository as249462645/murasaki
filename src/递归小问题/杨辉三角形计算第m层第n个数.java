package �ݹ�С����;

import java.util.Scanner;

public class ��������μ����m���n���� {
	public static int f(int m,int n){
		if(n==0||n==0||m==n) return 1;
		return f(m-1,n-1)+f(m-1,n);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(f(sc.nextInt(),sc.nextInt()));
	}
}
