package 深度优先搜索;

/*
 * 錯誤原因：行程的長度的結束條件
 */
import java.util.ArrayList;
import java.util.List;



public class 重新安排行程 {
	static List<String> list; // 已经规划好的行程

	public static void main(String[] args) {
		// System.out.println(minRoute("abc","aad")); minRoute() 测试
		String[][] a = new String[][]

		{ { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "JFK", "AXA" }, { "ANU", "JFK" }, { "ADL", "ANU" },
				{ "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" }, { "ADL", "EZE" }, { "EZE", "ADL" },
				{ "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" }, { "AXA", "AUA" }, { "AUA", "ADL" },
				{ "ANU", "EZE" }, { "TIA", "ADL" }, { "EZE", "ANU" }, { "AUA", "ANU" } };
		 System.out.println(findItinerary(a));
	}

	public static List<String> findItinerary(String[][] tickets) {
		list = new ArrayList<String>();
		f("JFK", tickets, 0);
		return list;
	}

	private static boolean f(String current, String[][] tickets, int k) { // current
		 System.out.println(current);
		
		list.add(current);
		if (k == tickets.length) // 行程安排完成
			return true;
		String[] someRoute = new String[tickets.length];
		int p = 0;
		for (int i = 0; i < tickets.length; i++) { // 获取可走路线
			if (tickets[i][0].equals(current)) {
				someRoute[p++] = tickets[i][1] + i; // 加i是为了标记某个行程被别安排，下个状态时不需要再安排
			}
		}

		if (p == 0) { // 此种走法到了尽头 但是没有安排完 回溯
			list.remove(k);
			return false;
		}

		String temp = "";
		for (int i = 0; i < p; i++) { // 给数组按字典排序
			for (int j = i + 1; j < p; j++) {
				if (minRoute(someRoute[i], someRoute[j]).equals(someRoute[j])) {
					temp = someRoute[i];
					someRoute[i] = someRoute[j];
					someRoute[j] = temp;
				}
			}
		}

		for (int i = 0; i < p; i++) { // 进入下一个状态
			String num = "";
			int leng = someRoute[i].length() - 1;
			while (Character.isDigit(someRoute[i].charAt(leng)))
				num = someRoute[i].charAt(leng--) + num;

			String s = tickets[Integer.parseInt(num)][0];
			tickets[Integer.parseInt(num)][0] = "";

			if (f(someRoute[i].substring(0, leng + 1), tickets, k + 1)) {
				return true;
			}

			tickets[Integer.parseInt(num)][0] = s; // 回溯
		}

		return false;
		// System.out.println(tickets[p][0].equals(orderRoute));
	}

	private static String minRoute(String str1, String str2) {
		// System.out.println(str1+" "+str2);
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		for (int i = 0; i < 3; i++) {
			if (ch1[i] < ch2[i])
				return str1;
			else if (ch1[i] > ch2[i])
				return str2;
		}
		return str1;
	}
}
