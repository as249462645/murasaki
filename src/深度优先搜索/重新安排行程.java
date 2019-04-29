package �����������;

/*
 * �e�`ԭ���г̵��L�ȵĽY���l��
 */
import java.util.ArrayList;
import java.util.List;



public class ���°����г� {
	static List<String> list; // �Ѿ��滮�õ��г�

	public static void main(String[] args) {
		// System.out.println(minRoute("abc","aad")); minRoute() ����
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
		if (k == tickets.length) // �г̰������
			return true;
		String[] someRoute = new String[tickets.length];
		int p = 0;
		for (int i = 0; i < tickets.length; i++) { // ��ȡ����·��
			if (tickets[i][0].equals(current)) {
				someRoute[p++] = tickets[i][1] + i; // ��i��Ϊ�˱��ĳ���г̱����ţ��¸�״̬ʱ����Ҫ�ٰ���
			}
		}

		if (p == 0) { // �����߷����˾�ͷ ����û�а����� ����
			list.remove(k);
			return false;
		}

		String temp = "";
		for (int i = 0; i < p; i++) { // �����鰴�ֵ�����
			for (int j = i + 1; j < p; j++) {
				if (minRoute(someRoute[i], someRoute[j]).equals(someRoute[j])) {
					temp = someRoute[i];
					someRoute[i] = someRoute[j];
					someRoute[j] = temp;
				}
			}
		}

		for (int i = 0; i < p; i++) { // ������һ��״̬
			String num = "";
			int leng = someRoute[i].length() - 1;
			while (Character.isDigit(someRoute[i].charAt(leng)))
				num = someRoute[i].charAt(leng--) + num;

			String s = tickets[Integer.parseInt(num)][0];
			tickets[Integer.parseInt(num)][0] = "";

			if (f(someRoute[i].substring(0, leng + 1), tickets, k + 1)) {
				return true;
			}

			tickets[Integer.parseInt(num)][0] = s; // ����
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
