package bronze;

import java.util.Scanner;

public class b3_2875_대회OR인턴 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		for (int i = 0; i <= k; i++) {
			// i :		빠질 여학생의 수
			// k - i :	빠질 남학생의 수
			int girl = n - i;
			int boy = m - (k - i);
			if(girl >= 0 && boy >= 0)
				answer = Math.max(answer, getTeam(girl, boy));
		}
		
		System.out.println(answer);
		return;
	}
	
	public static int getTeam(int n, int m) {
		// 여학생 2명당 남학생 1명
		// n / 2 : 여학생으로 꾸릴 수 있는 팀의 최대 수
		// m : 남학생으로 꾸릴 수 있는 팀의 최대 수
		
		return Math.min(n/2, m);
	}

}
