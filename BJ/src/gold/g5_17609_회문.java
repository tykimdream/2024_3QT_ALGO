package gold;

import java.util.Scanner;

public class g5_17609_ȸ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			char[] arr = sc.next().toCharArray();
			System.out.println(isPan(arr, 0, arr.length - 1, 0));
		}
	}

	public static int isPan(char[] arr, int start, int end, int deleted) {
		while (start < end) {
			if (arr[start] != arr[end]) {
				if (deleted == 0) {
					// ���ڸ� ���� �������� ���� ��츸 �߰� �˻�
					if (isPan(arr, start + 1, end, 1) == 0)
						return 1;
					if (isPan(arr, start, end - 1, 1) == 0)
						return 1;
					return 2;
				} else {
					// �̹� ���ڸ� �� �� �����ߴµ� �� �ٸ� ���ڸ� �Ұ���
					return 2;
				}
			}
			start++;
			end--;
		}
		return 0;
	}
}
