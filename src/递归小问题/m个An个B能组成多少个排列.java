package �ݹ�С����;

import java.util.Scanner;

public class m��An��B����ɶ��ٸ����� {
	static int f(int m,int n){
		if(m<=1) return n+m;
		if(n<=1) return m+n;
		return f(m-1,n)+f(m,n-1);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println(f(m,n));
	}

}
