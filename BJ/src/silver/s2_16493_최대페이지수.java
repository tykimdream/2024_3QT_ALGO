package silver;

import java.util.*;
import java.io.*;

public class s2_16493_최대페이지수 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] chaps = new int[m + 1][2];
		
		for(int i = 1; i <= m; i++) {
			 st = new StringTokenizer(br.readLine());

			chaps[i][0] = Integer.parseInt(st.nextToken());
			chaps[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[m + 1][n + 1];
				
		for(int i = 1; i <= m; i++) {
			int day = chaps[i][0];
			int page = chaps[i][1];
			for(int d = 1; d <= n; d++) {
				dp[i][d] = dp[i - 1][d];
				if(d >= day) {
					dp[i][d] = Math.max(dp[i][d], dp[i - 1][d - day] + page);
				}
			}
		}
		System.out.println(dp[m][n]);
	}

}
