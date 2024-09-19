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

		Arrays.sort(arr);

		int m = sc.nextInt();
		int target = 0;

		for (int i = 0; i < m; i++) {
			target = sc.nextInt();
			sb.append(binarySearch(arr, target, true) - binarySearch(arr, target, false)).append(" ");
		}
		System.out.println(sb.toString());
	}

	// false	: lower bound
	// true		: upper bound
	private static int binarySearch(int[] arr, int target, boolean isUpperBound) {
		int left = 0, right = arr.length;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < target || (isUpperBound && arr[mid] == target)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}