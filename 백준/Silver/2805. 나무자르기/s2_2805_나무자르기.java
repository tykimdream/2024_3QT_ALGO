package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long answer = 0;

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		long start = 0, end = arr[N - 1], cutted = 0;

		while (start <= end) { 
			long H = (end + start) / 2;
			cutted = getTree(arr, H);

			if (cutted >= M) {
				// H로 자르면 M보다 더 가져갈 수 있음
				// H를 더 높여야함
				start = H + 1;
				answer = Math.max(answer, H);
			} else {
				end = H - 1;
			}
		}
		System.out.println(answer);
	}

	public static long getTree(int[] arr, long mid) {
		long result = 0;
		for (int x : arr) {
			if (x - mid > 0)
				result += (x - mid);
		}
		return result;
	}
}
