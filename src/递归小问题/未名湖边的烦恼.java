package �ݹ�С����;


import java.util.Scanner;

public  class δ�����ߵķ��� {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println(f(sc.nextInt(), sc.nextInt()));
	}
	private static int f(int m,int n){
		if(n>m) return 0;     //��Ь�˴��ڻ�Ь�� ��ô�Ŷ�����
		if(n==0) return 1;    //û�н�Ь��ֻ��һ���ŷ�
		if(m==0) return 0;    //û�л�Ь����ô�Ŷ�����
		return f(m-1, n)+f(m, n-1);
	}
}

