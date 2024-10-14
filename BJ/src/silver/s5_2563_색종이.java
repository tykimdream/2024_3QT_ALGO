package silver;

import java.util.Scanner;

public class s5_2563_»öÁ¾ÀÌ {
	static int size = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] map = new boolean[101][101];
		int[][] rect = new int[N][2];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				rect[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			int x = rect[i][0];
			int y = rect[i][1];
			for (int dx = 0; dx < 10; dx++) {
				for (int dy = 0; dy < 10; dy++) {
					if (isIn(x + dx, y + dy)) {
						map[x + dx][y + dy] = true;
					}
				}
			}
		}

		for (boolean[] dx : map) {
			for (boolean dot : dx) {
				if (dot)
					answer++;
			}
		}
		System.out.println(answer);
		return;
	}

	public static boolean isIn(int x, int y) {
		return x >= 0 && x < 101 && y >= 0 && y < 101;
	}

}
