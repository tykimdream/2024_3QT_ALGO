import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, minGap, p1, p2;
	static int[] liquid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		liquid = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);

		minGap = Integer.MAX_VALUE;
				
		for(int i = 0; i < N; i++) {
			binsec(liquid[i], i + 1);
		}
		
		int min = Math.min(p1, p2);
		int max = Math.max(p1, p2);
		System.out.println(min + " " + max);
	}

	public static void binsec(int target, int start) {
		int end = N - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int mix = liquid[mid] + target;
			
			if(Math.abs(mix) < minGap) {
				minGap = Math.abs(mix);
				p1 = target;
				p2 = liquid[mid];
			}
			
			if(mix < 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}			
		}

	}

}