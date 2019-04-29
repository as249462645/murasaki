package 递归小问题;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class 账目明细 {
//	public static void f(int value,int[] a,int len){
////		for(int i=sum,)
//	}
	public static void f(int n,int[] a,int k,int value){ //k从1开始可降低代码的时间复杂度
		int num=0;
		for(int i=0;i<k;i++){
			num+=a[i];
		}
		if(num==value){
			for(int i=0;i<k;i++){
				System.out.print(a[i]);
			}
			System.out.println();
		}
		if(n<1){
			return;
		}
		for(int i=n;i>0;i--){
			a[k]=i; 
			f(n-i,a,k+1,value);
		}
	}
	public static void f1(int curr_num,int num,int[] a,boolean[] b,int k){
		if(curr_num>num) return;
		if(curr_num==num){
			for(int i=0;i<b.length;i++){
				if(!b[i]) System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		if(k>=b.length) return;
		b[k]=false;
		f1(curr_num,num,a,b,k+1);
		curr_num+=a[k];
		b[k]=true;
		f1(curr_num,num,a,b,k+1);
		b[k]=false;
		
	}
	public static void main(String[] args) {  
		Scanner sc=new Scanner(System.in);
		int money=sc.nextInt();
		int sum = 0;
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			sum+=a[i];
		}
		int value=sum-money;
		f1(0, money, a, new boolean[a.length],0);		
	}
}
