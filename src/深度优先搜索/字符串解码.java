package 深度优先搜索;

public class 字符串解码 { // 未测试 预计错误：字符越界
						// 问题解决

	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		// System.out.println(s.substring(s.indexOf("[")+1, s.indexOf("]")));
		System.out.println(decodeString(s));
	}

	public static String decodeString(String s) {
		if (s.equals("")) // 边界
			return "";
		String v = ""; // 结果
		if (Character.isDigit(s.charAt(0))) { // 如果是数字
			int index = 0;
			String i = "";
			while (Character.isDigit(s.charAt(index))) // 找到字符重复次数
				i += s.charAt(index++);
			int leftC = 1, rightC = 0; // leftC = '[' rightC=']'
			char[] ch = s.toCharArray();
			int stop = 0;
			for (stop = index + 1; stop < ch.length; stop++) { // 寻找子集开始和结束位置
				if (ch[stop] == '[')
					leftC++;
				if (ch[stop] == ']')
					rightC++;
				if (leftC == rightC)
					break;
			}

			String nextStringLeft = s.substring(index + 1, stop); // 获取子集

			String nextStringRight = s.substring(stop + 1, s.length()); // 获取剩余字符
			for (int k = 0; k < Integer.parseInt(i); k++) {
				v += decodeString(nextStringLeft);
			}

			v += decodeString(nextStringRight); // 剩余字符继续递归

		} else { // 是字符就加入结果
			int leng = 0;
			while (!Character.isDigit(s.charAt(leng))) { // 获取字符
				v += s.charAt(leng++);
				if (leng == s.length())
					break;
			}
			v += decodeString(s.substring(leng, s.length()));
		}
		return v;
	}
}
