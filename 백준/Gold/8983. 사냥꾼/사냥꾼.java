import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, N, L, answer;
	static int[] shootings;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		shootings = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			shootings[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(shootings);

		int x = 0, y = 0, gap = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			// 사거리를 넘는 y좌표는 못잡음
			if (y - L > 0)
				continue;
			gap = L - y;

			// x - gap ~ x + gap 사이에 위치한 사대가 있는지 확인
			// 있는 경우 사냥 가능한 동물이기 때문에 answer++;
			if (binsec(x - gap, x + gap))
				answer++;
		}
		System.out.println(answer);
	}

	public static boolean binsec(int lower, int upper) {
		// 구간에 해당하는 사대가 있는지 확인
		int start = 0, end = M - 1;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (shootings[mid] >= lower && shootings[mid] <= upper)
				return true;

			if (shootings[mid] > upper) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}