package bronze;

import java.io.*;
import java.util.*;

public class b2_16283_Farm {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		boolean flag = false;
		
		// a: 양 1일 소비량
		// b: 염소 1일 소비량
		// n: 양과 염소 전체 마리 수
		// 어제 하루 소비된 사료 양 W
		
		// 양을 기준으로 알아보자
		for(int i = 1; i < n; i++) {
			if((i * a) + ((n - i) * b) == w) {
				if(flag) {
					System.out.println(-1);
					return;
				}
				sb.append(i).append(" ").append(n - i);
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println(sb.toString());
			return;
		}

		System.out.println(-1);
		return;
	}
}
