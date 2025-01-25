package gold;

import java.util.Scanner;

public class g5_12865_Æò¹üÇÑ¹è³¶ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] items = new int[n + 1][2];
		
		for(int i = 1; i <= n; i++) {
			items[i][0] = sc.nextInt();
			items[i][1] = sc.nextInt();
		}
		
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 1; i <= n; i++) {
			int weight = items[i][0];
			int value = items[i][1];
			for(int w = 1; w <= k; w++) {
				dp[i][w] = dp[i - 1][w];
				if(w >= weight) {
					dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weight] + value);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
