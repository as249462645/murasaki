package 递归小问题;

import java.util.Arrays;
import java.util.Scanner;

public class 字符全排列 {
	static int count=0;
	public static void main(String[] args) {
		char[] ch=new Scanner(System.in).next().toCharArray();
//		f1(ch);
		long n=new java.util.Date().getTime();
		f2(ch,0);
		System.out.println(count);
		System.out.println(new java.util.Date().getTime()-n);
	}
	public static void f2(char[] ch,int n){     //递归
		if(n==ch.length)
			System.out.println(Arrays.toString(ch));
		for(int i=n;i<ch.length;i++){
			{char temp=ch[n];
			 ch[n]=ch[i];
			 ch[i]=temp;}
			 f2(ch,n+1);
			 {char temp=ch[n];
			 ch[n]=ch[i];
			 ch[i]=temp;}
		}
	}
	public static void f1(char[] ch){   //遍历   错误
		char temp;
		for(int i=0;i<=ch.length-1;i++){
			for(int j=0,k=1;j<ch.length-1;j++,k++){
				temp=ch[k];
				ch[k]=ch[j];
				ch[j]=temp;
				System.out.println(Arrays.toString(ch));
			}
		}
	}
}
