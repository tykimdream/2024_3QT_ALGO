import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Player {
	int pos, dice_count;

	public Player(int pos, int dice_count) {
		this.pos = pos;
		this.dice_count = dice_count;
	}
}

public class Main {

	static int N, M, answer = Integer.MAX_VALUE;
	static int[] eventMap = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			eventMap[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		Queue<Player> que = new LinkedList<>();
		int[] visited = new int[101];

		for (int i = 0; i < 101; i++) {
			visited[i] = Integer.MAX_VALUE;
		}

		que.offer(new Player(1, 0));

		while (que.isEmpty() == false) {
			Player p = que.poll();

			if (p.pos == 100) {
				System.out.println(p.dice_count);
				return;
			}

			if (visited[p.pos] < p.dice_count) {
				continue;
			}
			visited[p.pos] = p.dice_count;

			for (int dice = 1; dice <= 6; dice++) {
				int npos = p.pos + dice;
				if (isIn(npos) == false)
					continue;

				if (eventMap[npos] == 0) {
					que.offer(new Player(npos, p.dice_count + 1));
				} else {
					que.offer(new Player(eventMap[npos], p.dice_count + 1));
				}
			}

		}

	}

	public static boolean isIn(int pos) {
		return pos >= 1 && pos <= 100;
	}

}