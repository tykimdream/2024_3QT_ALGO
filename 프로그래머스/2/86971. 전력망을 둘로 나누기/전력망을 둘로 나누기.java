import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int len = wires.length;
        
        for(int i = 0; i < n; i++){
            List<Integer>[] nodes = new ArrayList[n + 1];
            
            for(int j = 0; j <= n; j++) {
                nodes[j] = new ArrayList<>();
            }
            
            // i 번째 인덱스의 전선을 끊어본다.
            // 연결 그래프 초기화
            for(int j = 0; j < len; j++){
                if(i == j) continue;
                nodes[wires[j][0]].add(wires[j][1]);
                nodes[wires[j][1]].add(wires[j][0]);
            }
            
            // System.out.println(i + "번째 와이어 컷");
            // for(int j = 1; j <= n; j++) {
            //     System.out.println(j + "번 노드: " + nodes[j]);
            // }
            
            if(nodes[1].size() == 0){
                // 0 : n 인 상황
                answer = Math.min(answer, n);
                continue;
            }
            
            // bfs를 실행할 que와 방문 처리 배열 초기화
            Queue<Integer> que = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            
            // 0번 노드부터 bfs를 돌린다.
            int area1 = 0;
            que.add(nodes[1].get(0));
            
            while(que.isEmpty() == false){
                int node = que.poll();
                area1++;
                visited[node] = true;
                for(int t = 0; t < nodes[node].size(); t++){
                    if(visited[nodes[node].get(t)] == false){
                        que.add(nodes[node].get(t));
                    }
                }
            }
            int area2 = n - area1;
            
            // System.out.println(i + "번째 시도 " + area1 + " " + (n - area1) + " gap : " + (area2 - area1));
            // area 1의 크기를 구하고 area 2는 n - area1
            // 두 값의 차이의 절대 값의 최소값을 구한다.
            
            answer = Math.min(answer, Math.abs(area2 - area1));
        }

        return answer;
    }
}