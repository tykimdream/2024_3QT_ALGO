package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_13423_TreeDots {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int count = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					int gap = arr[j] - arr[i];
					if (binsec(arr[i], arr) && binsec(arr[i] + gap, arr) && binsec(arr[i] + gap * 2, arr))
						count++;
				}
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean binsec(int target, int[] arr) {
		// arr 안에 target이 있는지 확인해야함
		// index로 접근
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = (end + start) / 2;
			if (arr[mid] == target)
				return true;
			if (arr[mid] < target)
				start = mid + 1;
			if (arr[mid] > target)
				end = mid - 1;
		}

		return false;
	}

}
