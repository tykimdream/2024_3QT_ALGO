function solution(park, routes) {
    const map = park.map(row => row.split(""))
    const h = map.length;
    const w = map[0].length;
    let x, y;
    
    // 시작 위치 찾기
    for(let i = 0; i < h; i++){
        for(let j = 0; j < w; j++){
            if(map[i][j] === 'S'){
                y = i;
                x = j;
                break;
            }
        }
    }
    
    routes.forEach((route) =>{
        const [direction, distance] = route.split(" ");
        let nx = x, ny = y;
        let canMove = true;
        
        // 한 칸씩 이동하면서 체크
        for(let i = 0; i < Number(distance); i++) {
            switch(direction){
                case "N":
                    ny--;
                    break;
                case "S":
                    ny++;
                    break;
                case "E":
                    nx++;
                    break;
                case "W":
                    nx--;
                    break;
            }
            
            // 범위를 벗어나거나 장애물을 만나면 이동 불가
            if(nx < 0 || nx >= w || ny < 0 || ny >= h || map[ny][nx] === "X"){
                canMove = false;
                break;
            }
        }
        
        // 이동이 가능한 경우에만 위치 업데이트
        if(canMove) {
            x = nx;
            y = ny;
        }
    })
    
    return [y, x];
}