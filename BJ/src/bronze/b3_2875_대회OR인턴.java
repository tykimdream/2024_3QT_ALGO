package bronze;

import java.util.Scanner;

public class b3_2875_��ȸOR���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		for (int i = 0; i <= k; i++) {
			// i :		���� ���л��� ��
			// k - i :	���� ���л��� ��
			int girl = n - i;
			int boy = m - (k - i);
			if(girl >= 0 && boy >= 0)
				answer = Math.max(answer, getTeam(girl, boy));
		}
		
		System.out.println(answer);
		return;
	}
	
	public static int getTeam(int n, int m) {
		// ���л� 2��� ���л� 1��
		// n / 2 : ���л����� �ٸ� �� �ִ� ���� �ִ� ��
		// m : ���л����� �ٸ� �� �ִ� ���� �ִ� ��
		
		return Math.min(n/2, m);
	}

}
