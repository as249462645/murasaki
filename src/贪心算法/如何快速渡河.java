package 贪心算法;

public class 如何快速渡河 {

	public static void main(String[] args) {
		int n = 4; // 人数
		int[] speed = new int[] { 1, 2, 3, 4 };// 每个人的速度
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
