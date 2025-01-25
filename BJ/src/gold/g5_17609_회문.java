package gold;

import java.util.Scanner;

public class g5_17609_회문 {
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
					// 문자를 아직 삭제하지 않은 경우만 추가 검사
					if (isPan(arr, start + 1, end, 1) == 0)
						return 1;
					if (isPan(arr, start, end - 1, 1) == 0)
						return 1;
					return 2;
				} else {
					// 이미 문자를 한 번 삭제했는데 또 다른 문자면 불가능
					return 2;
				}
			}
			start++;
			end--;
		}
		return 0;
	}
}
