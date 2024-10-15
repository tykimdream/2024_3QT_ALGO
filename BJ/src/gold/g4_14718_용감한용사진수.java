package gold;

import java.util.Scanner;

public class g4_14718_�밨�ѿ������ {

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
					// ��, ��ø, ������ ����
					str = soliders[i][0];
					dex = soliders[j][1];
					ity = soliders[k][2];
					count = 0;
					
					// �ش� �������� ���� ��ȸ
					for (int t = 0; t < n; t++) {
						if (str >= soliders[t][0] && dex >= soliders[t][1] && ity >= soliders[t][2]) {
							count++;
						}
					}
					
					// �ش� �������� ���� �� �ִ� ���簡 m �̻��� ��� answer �ֽ�ȭ
					if (count >= m) {
						answer = Math.min(answer, (str + dex + ity));
					}
				}
			}
		}
		
		System.out.println(answer);

	}

}
