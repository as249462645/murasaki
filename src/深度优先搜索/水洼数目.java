package 深度优先搜索;

public class 水洼数目 {
	static int[][] fx = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 },
			{ 1, -1 } };

	public static void main(String[] args) {
		String[][] map = new String[][] {};
		int count = 0;
		if (map.length == 0)
			System.out.println(0);
		else {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j].equals("W")) {
						count++;
						f(i, j, map);
					}

				}
			}
		}
	}

	private static void f(int i, int j, String[][] map) {
		if (i >= map.length || j >= map.length || i < 0 || j < 0 || map[i][j].equals("."))
			return;
		map[i][j] = ".";
		for (int k = 0; k < 8; k++)
			f(i + fx[k][0], j + fx[k][1], map);
	}

}
