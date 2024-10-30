class Solution {
    static int len, answer;
    static boolean[] visited;    
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public static void dfs(int depth, int heal, int[][] dungeons){
        answer = Math.max(answer, depth);
        
        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            if(heal >= dungeons[i][0]){
                visited[i] = true;
                dfs(depth + 1, heal - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
    
}