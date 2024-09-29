package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_16498_작은벌점 {
	static int A, B, C, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] aList = new int[A];
		int[] bList = new int[B];
		int[] cList = new int[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			aList[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			bList[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			cList[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(bList);
		Arrays.sort(cList);

		// aList를 순회하면서 해당 수를 기준으로 찾는다.
		for (int i = 0; i < A; i++) {
			if(answer == 0) break;
			// B중 A와 가까운 숫자를 찾는다.
			int b = binsec(aList[i], bList);
			
			// C중 B와 가까운 숫자를 찾는다.
			int ctoB = binsec(b, cList);
			
			// C중 A와 가까운 숫자를 찾는다.
			int ctoA = binsec(aList[i], cList);
			
			// a, b, c1
			int min = Math.min(aList[i], Math.min(b, ctoB));
			int max = Math.max(aList[i], Math.max(b, ctoB));
			answer = Math.min(answer, Math.abs(max - min));
			
			// a, b, c2
			min = Math.min(aList[i], Math.min(b, ctoA));
			max = Math.max(aList[i], Math.max(b, ctoA));
			answer = Math.min(answer, Math.abs(max - min));
		}
		
		System.out.println(answer);
	}
	
	public static int binsec(int target, int[] arr) {
		int nearest = arr[0], start = 0, end = arr.length - 1;
		
		while(start <= end) {
			int mid = (end + start) / 2;
			
			if(arr[mid] == target) return target;
			
			if(arr[mid] < target) {
				start = mid + 1;
			}
			if(arr[mid] > target) {
				end = mid - 1;
			}
			if(Math.abs(nearest - target) > Math.abs(arr[mid] - target))
			nearest = arr[mid];
		}
		
		return nearest;
	}

}
