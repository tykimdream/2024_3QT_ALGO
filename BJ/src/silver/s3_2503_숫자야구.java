package silver;

import java.util.Scanner;

public class s3_2503_숫자야구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][3];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}

		// 게임을 진행한다.
		for (int i = 123; i <= 987; i++) {
			// 중복 수면 거른다 ex) 222, 333, 444 ...
			if (duplicate(i))
				continue;

			// 현재 i가 가능한지 검토
			int possible = 0;
			for (int t = 0; t < n; t++) {
				int strike_count = 0;
				int ball_count = 0;
				String[] nums = getNumString(arr[t][0]);
				String[] targets = getNumString(i);

				// strike count
				for (int s = 0; s < 3; s++) {
					if (targets[s].equals(nums[s]))
						strike_count++;
				}

				// ball count
				for (int b = 0; b < 3; b++) {
					for (int tb = 0; tb < 3; tb++) {
						if (b != tb && targets[tb].equals(nums[b]))
							ball_count++;
					}
				}

				// valid check
				if (arr[t][1] == strike_count && arr[t][2] == ball_count)
					possible++;
			}
			if (possible == n)
				answer++;
		}

		System.out.println(answer);
		return;
	}

	private static boolean duplicate(int input) {
		String[] nums = getNumString(input);
		if (nums[0].equals("0") || nums[1].equals("0") || nums[2].equals("0"))
			return true;
		return (nums[0].equals(nums[1]) || nums[0].equals(nums[2]) || nums[1].equals(nums[2])) ? true : false;
	}

	private static String[] getNumString(int input) {
		String[] result = new String[3];
		String inputString = Integer.toString(input);

		for (int i = 0; i < 3; i++) {
			result[i] = inputString.charAt(i) + "";
		}

		return result;
	}
}
