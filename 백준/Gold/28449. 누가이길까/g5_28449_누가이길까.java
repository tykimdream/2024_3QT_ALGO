package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_28449_누가이길까 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Hi = Integer.parseInt(st.nextToken());
		int ARC = Integer.parseInt(st.nextToken());

		int[] teamHi = new int[Hi];
		int[] teamARC = new int[ARC];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Hi; i++) {
			teamHi[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ARC; i++) {
			teamARC[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(teamHi);
		Arrays.sort(teamARC);

		long hiWinCount = 0;
		long ARCWinCount = 0;
		long drawCount = 0;
		
        for(int x : teamHi) {
        	int lower = lowerBound(x, teamARC);
        	int upper = upperBound(x, teamARC);
        	
        	hiWinCount += lower;
        	drawCount += (upper - lower);
        }
        for(int x : teamARC) {
        	ARCWinCount += lowerBound(x, teamHi);
        }
        
		System.out.println(hiWinCount + " " + ARCWinCount + " " + drawCount);
	}

	public static int lowerBound(int target, int[] arr) {
		int start = 0, end = arr.length;
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
	
	public static int upperBound(int target, int[] arr) {
		int start = 0, end = arr.length;
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}
