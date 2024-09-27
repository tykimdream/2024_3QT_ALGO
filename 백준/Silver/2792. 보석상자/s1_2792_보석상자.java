package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_2792_보석상자 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = Integer.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M];
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		// 한 학생에게 줄 수 있는 수 : 1 ~ arr[M-1]
		int start = 1, end = arr[M - 1];
		while(start <= end) {
			int perOne = (end + start) / 2;
			// perOne으로 지급 시, 
			// 몇 명의 학생에게 지급이며, 남는 값의 최대는 몇인가
			int student = 0, jeal = 0;
			for(int jul: arr) {
				student += jul / perOne;
				if(jul % perOne != 0) student++;
			}
			if(student <= N) {
				// 지급 가능함이 확인되면, 최신화 및 주는 량 줄여보기
				answer = Math.min(perOne, answer);
				end = perOne - 1;
			} else {
				// 지급이 안된다 = 1인당 지급량 늘리기
				start = perOne + 1;
			} 
		}
		
		System.out.println(end + 1);
	}

}
