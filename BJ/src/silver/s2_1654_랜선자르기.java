package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_1654_�����ڸ��� {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(binsec());
	}

	public static int binsec() {
		int mid, start = 0, end = N - 1;

		while (start <= end) {
			mid = start + (end - start) / 2;
			// mid�� �������� �߶��� �� �����ϴ� �� Ȯ��
			
		}
		return 0;
	}

}
