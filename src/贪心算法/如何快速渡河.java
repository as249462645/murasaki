package ̰���㷨;

public class ��ο��ٶɺ� {

	public static void main(String[] args) {
		int n = 4; // ����
		int[] speed = new int[] { 1, 2, 3, 4 };// ÿ���˵��ٶ�
		System.out.println(minTime(speed, 0, speed.length));
	}

	private static int minTime(int[] speed, int s, int person) {
		if (person == 1)
			return s+speed[0];
		else if (person == 2)
			return s+speed[1];
		else if (person == 3)
			return s+speed[0] + speed[1] + speed[2];
		else {
			int s1 = speed[person - 1] + speed[person - 2] + 2 * speed[0];
			int s2 = speed[1] + speed[0] + speed[person - 2] + speed[1];
			return minTime(speed, Math.min(s1, s2), person-2);
		}
	}
}
