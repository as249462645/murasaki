package �ݹ�С����;

import java.util.Scanner;

public class �������� {
	static int num;
	public static void f(int n){  //�����ܻ��ֳ�������   �ݹ���ʽ
		if(n<=3){num+=n; return ;}
		for(int i=1;i<=n;i++){
			f(n-i);
		}
	}
	public static void f(int n,int[] a,int k){ //k��1��ʼ�ɽ��ʹ����ʱ�临�Ӷ�
		if(n<1){
			for(int i=1;i<k;i++)
 				System.out.print(a[i]);
			System.out.println();
			return;
		}
		for(int i=n;i>0;i--){
			if(a[k-1]<i) continue;    //ȥ�ز���
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
