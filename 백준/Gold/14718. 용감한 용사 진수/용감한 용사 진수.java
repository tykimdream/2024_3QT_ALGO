import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] soldiers;
	static int[] peek;
	static int cnt; // 이길 수 있는 병사 수 체크
	static int answer = Integer.MAX_VALUE;

	static void statCheck(int depth) {
		if (depth == 3) {

			cnt = 0;
			for (int i = 0; i < N; i++) {
				if (peek[0] >= soldiers[i][0] && peek[1] >= soldiers[i][1] && peek[2] >= soldiers[i][2]) {
					cnt++;
				}
			}

			if (cnt >= K) {
				answer = Math.min(answer, peek[0] + peek[1] + peek[2]);
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			peek[depth] = soldiers[i][depth];
			statCheck(depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		soldiers = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			soldiers[i][0] = Integer.parseInt(st.nextToken());
			soldiers[i][1] = Integer.parseInt(st.nextToken());
			soldiers[i][2] = Integer.parseInt(st.nextToken());
		}

		peek = new int[3];

		statCheck(0);

		System.out.println(answer);
	}
}