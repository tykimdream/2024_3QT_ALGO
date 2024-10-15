package silver;

import java.util.Arrays;
import java.util.Scanner;

public class s5_10815_����ī�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// �̺� Ž���� ���� ����
		Arrays.sort(arr);

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			sb.append(binsec(arr, 0, n - 1, sc.nextInt()) ? 1 : 0).append(" ");
		}

		System.out.println(sb.toString());
	}

	private static boolean binsec(int[] arr, int bottom, int top, int target) {
		// �̺� Ž������ �ش� ���� arr�� �ִ��� Ȯ���Ѵ�.
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
