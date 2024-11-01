import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		// 인접 리스트 사용
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
		
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        
        while(que.isEmpty() == false) {
        	int current = que.poll();
        	
        	for(int next : graph.get(current)) {
        		if(distance[next] == -1) {
        			distance[next] = distance[current] + 1;
        			que.add(next);
        		}
        	}
        }
        
        boolean found = false;
        for(int i = 1; i <= n; i++) {
            if(distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        
        if(!found) System.out.println(-1);
	}
}