import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 이분 탐색을 위해 정렬
		Arrays.sort(arr);

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			if (binsec(arr, 0, n - 1, sc.nextInt()))
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}

		System.out.println(sb.toString());
	}

	private static boolean binsec(int[] arr, int bottom, int top, int target) {
		// 이분 탐색으로 해당 수가 arr에 있는지 확인한다.

		while (top >= bottom) {
			int index = (top + bottom) / 2;
			if (arr[index] == target)
				return true;
			if (arr[index] > target) {
				top = index - 1;
			}
			if (arr[index] < target) {
				bottom = index + 1;
			}
		}

		return false;
	}
}