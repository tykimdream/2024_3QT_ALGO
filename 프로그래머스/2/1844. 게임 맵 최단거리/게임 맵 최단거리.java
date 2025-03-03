import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] vMap;
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        Queue<int[]> que = new LinkedList<>();
        vMap = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                vMap[i][j] = Integer.MAX_VALUE;
            }
        }
        
        que.offer(new int[]{0, 0, 1});
        
        while(que.isEmpty() == false){
            int[] temp = que.poll();
            int x = temp[0];
            int y = temp[1];
            int value = temp[2];
            
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(isIn(nx, ny) == false) continue;
                if(maps[nx][ny] == 1 && vMap[nx][ny] > value + 1){
                    vMap[nx][ny] = value + 1;
                    que.offer(new int[] {nx, ny, value + 1});
                }
            }
        }
                
        return vMap[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : vMap[n - 1][m - 1];
    }
    
    public boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}