import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] list = new int[n + 1][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			list[i][0] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n + 1][100];
		
		for(int i = 1; i <= n; i++) {
			int pain = list[i][0];
			int plez = list[i][1];
			for(int p = 1; p <= 99; p++) {
				dp[i][p] = dp[i - 1][p];
				if(p >= pain) {
					dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - pain] + plez);
				}
			}
		}
		System.out.println(dp[n][99]);
	}
}