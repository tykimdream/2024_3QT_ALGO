import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] liq = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = n - 1;
		
		Arrays.sort(liq);
		
		int min = Integer.MAX_VALUE;
		int left = 0, right = 0;
		while(start < end) {
			int compo = liq[start] + liq[end];
			if(min > Math.abs(compo)) {
				min = Math.abs(compo);
				left = liq[start];
				right = liq[end];
			}
			if(compo < 0) {
				start++;
			} else if (compo > 0){
				end--;
			} else {
				System.out.println(left + " " + right);
				return;
			}
		}
		
		System.out.println(left + " " + right);
		
		

	}

}