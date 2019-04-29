package �����������;

public class �ַ������� { // δ���� Ԥ�ƴ����ַ�Խ��
						// ������

	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		// System.out.println(s.substring(s.indexOf("[")+1, s.indexOf("]")));
		System.out.println(decodeString(s));
	}

	public static String decodeString(String s) {
		if (s.equals("")) // �߽�
			return "";
		String v = ""; // ���
		if (Character.isDigit(s.charAt(0))) { // ���������
			int index = 0;
			String i = "";
			while (Character.isDigit(s.charAt(index))) // �ҵ��ַ��ظ�����
				i += s.charAt(index++);
			int leftC = 1, rightC = 0; // leftC = '[' rightC=']'
			char[] ch = s.toCharArray();
			int stop = 0;
			for (stop = index + 1; stop < ch.length; stop++) { // Ѱ���Ӽ���ʼ�ͽ���λ��
				if (ch[stop] == '[')
					leftC++;
				if (ch[stop] == ']')
					rightC++;
				if (leftC == rightC)
					break;
			}

			String nextStringLeft = s.substring(index + 1, stop); // ��ȡ�Ӽ�

			String nextStringRight = s.substring(stop + 1, s.length()); // ��ȡʣ���ַ�
			for (int k = 0; k < Integer.parseInt(i); k++) {
				v += decodeString(nextStringLeft);
			}

			v += decodeString(nextStringRight); // ʣ���ַ������ݹ�

		} else { // ���ַ��ͼ�����
			int leng = 0;
			while (!Character.isDigit(s.charAt(leng))) { // ��ȡ�ַ�
				v += s.charAt(leng++);
				if (leng == s.length())
					break;
			}
			v += decodeString(s.substring(leng, s.length()));
		}
		return v;
	}
}
