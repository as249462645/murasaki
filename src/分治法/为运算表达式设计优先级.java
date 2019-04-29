package 分治法;

import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级 {
	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2*3-4*5"));
		System.out.println(f("2*3-4*5"));
	}
    public static List<Integer> diffWaysToCompute(String input) {
        //分治算法
        List<Integer> list = new ArrayList<Integer>();
        boolean flag = false;
        for(int i = 0; i < input.length(); ++i){
            if(Character.isDigit(input.charAt(i))) continue;
            flag = true; 
            List<Integer> lList = diffWaysToCompute(input.substring(0,i));
            List<Integer> rList = diffWaysToCompute(input.substring(i+1,input.length()));
            for(int m : lList){
                for(int n : rList){
                    char op = input.charAt(i);
                    int result = 0;
                    switch (op){
                        case '+': result = m + n;break;
                        case '-': result = m - n;break;
                        case '*': result = m * n;break;
                    }
                    list.add(result);
                }
            }
        }
        if(flag == false) list.add(Integer.parseInt(input));
//        System.out.println(list);
        return list;
    }
    public static List<Integer> f(String input){
    	List<Integer> list=new ArrayList<Integer>();
    	boolean flag=true;
    	for(int i=0;i<input.length();i++){
    		if(Character.isDigit(input.charAt(i))) continue;
    		List<Integer> leftList=f(input.substring(0,i));
    		List<Integer> rightList=f(input.substring(i+1, input.length()));
    		flag=false;
    		for(int m:leftList)
    			for(int n:rightList){
    				int num=0;
    				switch(input.charAt(i)){
    					case '+' : num=m+n;break;
    					case '-' : num=m-n;break;
    					case '*' : num=m*n;break;
    				}
    				list.add(num);
    			}
    				
    	}
    	if(flag) list.add(Integer.parseInt(input));
    	return list;
    }
}

