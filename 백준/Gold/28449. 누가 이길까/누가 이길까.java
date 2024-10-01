import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long Hi = Long.parseLong(st.nextToken());
		long ARC = Long.parseLong(st.nextToken());

		int[] teamHi = new int[(int) Hi];
		int[] teamARC = new int[(int)ARC];

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
		
		long hiWinCount = 0, ARCWinCount = 0, drawCount = 0;
		
		for(int x : teamHi){
			hiWinCount += binsec(x, teamARC);
		}
		
		for(int x : teamARC){
			ARCWinCount += binsec(x, teamHi);
		}
		drawCount = ((long) Hi * ARC) - hiWinCount - ARCWinCount;
		System.out.println(hiWinCount + " " + ARCWinCount  + " " + drawCount);
	}

	public static int binsec(int x, int[] enemy) {
		int start = 0, end = enemy.length, mid = 0;
		while(start < end) {
			mid = (start + end) / 2;
			if(x > enemy[mid]) {
				start = mid + 1;
			} else
				end = mid;
		}
		return start;
	}
}