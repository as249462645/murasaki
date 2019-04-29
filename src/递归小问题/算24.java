package µ›πÈ–°Œ Ã‚;

import java.util.Scanner;

public class À„24 {
	static int[] a=new int[4];
	static int[] p=new int[4];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<4;i++){
			a[i]=sc.nextInt();
		}
		f(0,0, "");
	}

	private static void f(int v,int n, String string) {
		if(v==24)System.out.println(string);
		if(n==4) return;
		p[n]=1;
		f(v+a[n], n+1, a[n]+"+");
		f(v-a[n], n+1, string);
		p[n]=0;
		
	}

}
