package gold;

import java.util.*;
import java.io.*;

public class g4_18223_민준이와마산그리고건우 {

	static class Node implements Comparable<Node>{
		int a, b;
		
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.a - n.a;
		}
	}
	
	static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new int[] {end, cost});
			graph.get(end).add(new int[] {start, cost});
		}

		
		if(djs(1, p, v) + djs(p, v, v) == djs(1, v, v)) {
			System.out.println("SAVE HIM");
		} else {
			System.out.println("GOOD BYE");
		}
		
	}
	
	public static int djs(int start, int end, int v) {
		int[] distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {start, 0});
        distance[start] = 0;
        
        while(pq.isEmpty() == false) {
        	int[] current = pq.poll();
            int currentVertex = current[0];
            int currentCost = current[1];
            
            if(currentVertex == end) break;
            if(distance[currentVertex] < currentCost) continue;
            
            for(int[] next : graph.get(currentVertex)) {
            	int nextVertex = next[0];
                int nextCost = next[1];
                int newCost = distance[currentVertex] + nextCost;
                
                if(newCost < distance[nextVertex]) {
                    distance[nextVertex] = newCost;
                    pq.offer(new int[] {nextVertex, newCost});
                }
            }
        }
        
        
		return distance[end];
	}

}











