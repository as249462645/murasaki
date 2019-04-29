package 递归小问题;

import java.util.Scanner;

public class 整数划分 {
	static int num;
	public static void f(int n){  //计算能划分出多少种   递归形式
		if(n<=3){num+=n; return ;}
		for(int i=1;i<=n;i++){
			f(n-i);
		}
	}
	public static void f(int n,int[] a,int k){ //k从1开始可降低代码的时间复杂度
		if(n<1){
			for(int i=1;i<k;i++)
 				System.out.print(a[i]);
			System.out.println();
			return;
		}
		for(int i=n;i>0;i--){
			if(a[k-1]<i) continue;    //去重操作
			a[k]=i;
			f(n-i,a,k+1);
		}
	}
	public static void main(String[] args) {
		int[] a=new int[100];   
		a[0]=9999999;
		f(new Scanner(System.in).nextInt(),a,1);
		f(4);
		System.out.println(num);
	}
}
