package �����������;

import java.util.Scanner;

public class Ѱ·���� {
	static int k;
	static int n;
	static int r;
	static int[][] path;
	static int[] flag;
	static int lenth=Integer.MAX_VALUE;
	static int[][] zj; //��ǰλ��  ȫ����·��   �߹���·��
	public static void main(String[] args){
		Scanner  sc=new Scanner(System.in);
		k=sc.nextInt();
		n=sc.nextInt();
		r=sc.nextInt();
		path=new int[r][4];
		flag=new int[n+1];
		zj=new int[n][k];
		for(int i=0;i<r;i++){
			path[i][0]=sc.nextInt();
			path[i][1]=sc.nextInt();
			path[i][2]=sc.nextInt();
			path[i][3]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<k;j++){
				zj[i][j]=Integer.MAX_VALUE;
			}
		}
		f(1, 0, 0);
		if(lenth==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(lenth);
		
	}
	private static void f(int p,int m,int len) {
//		System.out.println(p);
//		if(zj[p][m][len]==1) return;
		if(m>k){ 
//			zj[p][m][len]=1;
			return;
		}
		if(p==n)
			lenth=Math.min(len, lenth);
		if(len>=lenth) return;        //����Ѿ��߹����ǻ�û���յ��·�Ѿ�����һ���ҵ���·������   ��û�б�Ҫ������ȥ��
		if(len>zj[p][m]) return;
		zj[p][m]=len;  
		for(int i=0;i<r;i++){
			if(path[i][0]==p&&flag[path[i][1]]!=1){
				flag[path[i][1]]=1;
				f(path[i][1], m+path[i][3],len+path[i][2]);
				flag[path[i][1]]=0;
			}
		}
	}
}
