package еепР;

import java.util.Arrays;

public class ц╟ещеепР {

	public static void main(String[] args) {
		int[] a=new int[]{6,8,7,4,2,5,3};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(a[i]<a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
