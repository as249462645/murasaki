package 动态规划;

import util.Util;

public class 最大上升子序列 {
	static int[] D;
	public static void main(String[] args) {
		int[] a = new int[] { 0,1, 7, 3, 5, 9, 4, 8 };
		D=new int[a.length+1];
		for(int i=1;i<a.length;i++){
			D[i]=1;
		}
//		System.out.println(f1(a, 1,1, a[0]));
		System.out.println(f2(a));
	}

	public static int f1(int[] a, int maxLen, int p,int pNumber) { // 递归
		if(p==a.length) return maxLen;
//		if(D[p][maxLen]!=0) return D[p][maxLen];
		int maxOne = 0,maxTow=0;
		if(pNumber<a[p])
			maxOne = f1(a, maxLen+1, p+1, a[p]);
		maxTow=f1(a, maxLen, p+1, pNumber);
//		D[p][maxLen]= Math.max(maxOne, maxTow);
		return Math.max(maxOne, maxTow);
	}
	
	public static int f2(int[] a){  //动态规划
		for(int i=2;i<a.length;i++){
			for(int j=1;j<i;j++){
				if(a[i]>a[j])
					D[i]=Math.max(D[i], D[j]+1);
			}
		}
		return D[a.length-1];
	}
}
