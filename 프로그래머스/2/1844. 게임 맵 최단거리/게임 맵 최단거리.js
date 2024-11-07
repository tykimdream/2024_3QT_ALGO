function solution(maps) {
    const dx = [-1, 1, 0, 0];
    const dy = [0, 0, -1, 1];
    
    const n = maps.length;
    const m = maps[0].length;
    
    const visited = Array(n).fill().map(() => Array(m).fill(false));
    visited[0][0] = true;
    
    const que = [];
    que.push([0, 0, 1]);
    
    while(que.length > 0){
        const [x, y, w] = que.shift();

        if(x === n - 1 && y === m - 1){
            return w;
        }
        for(let d = 0; d < 4; d++){
            let nx = x + dx[d];
            let ny = y + dy[d];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(maps[nx][ny] === 1 && visited[nx][ny] === false){
                    visited[nx][ny] = true;
                    que.push([nx, ny, w + 1]);
                }
            }
        }
    }
    
    
    
    return -1;
}







