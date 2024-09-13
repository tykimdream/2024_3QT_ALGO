import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Set<Integer> set = new TreeSet<>();

		for (int x = -1000; x <= 1000; x++) {
			if (x * x + 2 * a * x + b == 0) {
				set.add(x);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int x : set) {
			sb.append(x).append(" ");
		}
		System.out.println(sb.toString().trim());

	}
}