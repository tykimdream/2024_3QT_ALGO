const dx = [0, 1, 0, -1];
const dy = [-1, 0, 1, 0];
let w, h;

function solution(land) {
    let answer = 0;
    w = land[0].length;
    h = land.length;
    
    let visited = Array(h).fill().map(() => Array(w).fill(false));
    let oilSizes = {};
    let oilId = 2;
    
    // 모든 석유 덩어리 찾기 및 크기 계산
    for(let y = 0; y < h; y++){
        for(let x = 0; x < w; x++){
            if(land[y][x] === 1 && !visited[y][x]){
                let size = BFS(land, visited, y, x, oilId);
                oilSizes[oilId] = size;
                oilId++;
            }
        }
    }
    
    // 각 열에 대해 석유량 계산
    for(let x = 0; x < w; x++){
        let columnOil = new Set();
        for(let y = 0; y < h; y++){
            if(land[y][x] >= 2){
                columnOil.add(land[y][x]);
            }
        }
        let totalOil = Array.from(columnOil).reduce((sum, id) => sum + oilSizes[id], 0);
        answer = Math.max(answer, totalOil);
    }
    
    return answer;
}

function BFS(land, visited, y, x, id){
    let que = [[y, x]];
    visited[y][x] = true;
    land[y][x] = id;
    let size = 1;
    
    while(que.length > 0){
        let [sy, sx] = que.shift();
        
        for(let d = 0; d < 4; d++){
            let nx = sx + dx[d];
            let ny = sy + dy[d];
            if(isIn(ny, nx) && land[ny][nx] === 1 && !visited[ny][nx]){
                visited[ny][nx] = true;
                land[ny][nx] = id;
                que.push([ny, nx]);
                size++;
            }
        }
    }
    return size;
}

function isIn(ny, nx){
    return ny >= 0 && ny < h && nx >= 0 && nx < w;
}