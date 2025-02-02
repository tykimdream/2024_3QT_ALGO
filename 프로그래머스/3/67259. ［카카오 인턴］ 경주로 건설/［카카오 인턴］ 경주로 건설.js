function solution(board) {   
    const MAX_VALUE = 123456789
    // 상, 좌, 우, 하 <- 인덱스의 합이 3이면 직선, 아니면 교차로
    const dx = [-1, 0, 0, 1];
    const dy = [0, -1, 1, 0];
    
    const n = board.length;
    const dp = Array(n).fill().map(() => Array(n).fill(MAX_VALUE));
    
    let que = [[0, 0, -1, 0]];
    
    while(que.length > 0){
        const [x, y, dir, cost] = que.shift();
        
        for(let d = 0; d < 4; d++){
            const nx = x + dx[d];
            const ny = y + dy[d];
            
            let ncost = 0;
            if(dir === d || dir === -1){ 
                ncost = 100;
            }else {
                ncost = 600;
            }
            ncost += cost;
            
            if(isIn(nx, ny) && (dp[nx][ny] > ncost - 500) && board[nx][ny] === 0){
                que.push([nx, ny, d, ncost]);
                dp[nx][ny] = Math.min(dp[nx][ny], ncost)
                // dp[nx][ny] = ncost;
            }
        }
    } 
    
    function isIn(nx, ny){
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
    
    return dp[n - 1][n - 1];
}
    
