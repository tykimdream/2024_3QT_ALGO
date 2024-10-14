package gold;

import java.util.Scanner;

public class g4_14718_용감한용사진수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] soliders = new int[n][3];
		int str, dex, ity, count, answer = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				soliders[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					// 힘, 민첩, 지능을 추출
					str = soliders[i][0];
					dex = soliders[j][1];
					ity = soliders[k][2];
					count = 0;
					
					// 해당 스탯으로 병사 순회
					for (int t = 0; t < n; t++) {
						if (str >= soliders[t][0] && dex >= soliders[t][1] && ity >= soliders[t][2]) {
							count++;
						}
					}
					
					// 해당 스탯으로 잡을 수 있는 병사가 m 이상인 경우 answer 최신화
					if (count >= m) {
						answer = Math.min(answer, (str + dex + ity));
					}
				}
			}
		}
		
		System.out.println(answer);

	}

}
