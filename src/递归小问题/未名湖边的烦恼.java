package 递归小问题;


import java.util.Scanner;

public  class 未名湖边的烦恼 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println(f(sc.nextInt(), sc.nextInt()));
	}
	private static int f(int m,int n){
		if(n>m) return 0;     //借鞋人大于还鞋人 怎么排都不行
		if(n==0) return 1;    //没有借鞋人只有一种排法
		if(m==0) return 0;    //没有还鞋人怎么排都不行
		return f(m-1, n)+f(m, n-1);
	}
}

