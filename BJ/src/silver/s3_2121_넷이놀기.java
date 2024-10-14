package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_2121_≥›¿Ã≥Ó±‚ {
	public static int N, A, B, answers;
	public static int[][] points_x, points_y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		points_x = new int[N][2];
		points_y = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points_x[i] = new int[] { x, y };
			points_y[i] = new int[] { x, y };
		}

		Arrays.sort(points_x, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		Arrays.sort(points_y, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

		for (int[] points : points_x) {
			int x = points[0];
			int y = points[1];
			if (binarySearchX(x + A, y) && binarySearchY(x, y + B) && binarySearchX(x + A, y + B))
				answers++;
		}
		System.out.println(answers);
	}

    static boolean binarySearchX(int x, int y) {
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (points_x[mid][0] == x) {
                if (points_x[mid][1] == y) return true;
                if (points_x[mid][1] < y) left = mid + 1;
                else right = mid - 1;
            } else if (points_x[mid][0] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    static boolean binarySearchY(int x, int y) {
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (points_y[mid][1] == y) {
                if (points_y[mid][0] == x) return true;
                if (points_y[mid][0] < x) left = mid + 1;
                else right = mid - 1;
            } else if (points_y[mid][1] < y) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}