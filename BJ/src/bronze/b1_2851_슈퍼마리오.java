package bronze;

import java.util.Scanner;

public class b1_2851_���۸����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			// ���簡 100�� ������
			// �Դ°� 100�� �����ĸ� ������
			if(Math.abs(100 - sum) >= Math.abs(100 - (sum + arr[i]))) {
				sum+=arr[i];
			} else {
				break;
			}
		}
		System.out.println(sum);

		return;
	}
}
