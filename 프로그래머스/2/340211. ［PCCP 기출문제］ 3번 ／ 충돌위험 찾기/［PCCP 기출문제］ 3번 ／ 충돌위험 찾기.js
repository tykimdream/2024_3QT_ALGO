class Robot{
    constructor(points, route){
        this.route = route.map((r) => points[r - 1]);
        this.pos = [...this.route[0]];
        this.dest = [...this.route[1]];
        this.route.splice(0, 2);
        this.arrive = 0;
    }
    setNextDest(points){
        this.dest = this.route.shift();
    }
}

function isAllArrive(list){
    for(robot of list){
        if(robot.arrive != 2) return false;
    }
    return true;
}

function countCrush(print, list){
    let map = new Map();
    let result = 0;
    
    for(robot of list){
        if(robot.arrive == 2) continue;
        let key = `${robot.pos[0]},${robot.pos[1]}`;
        if(map.has(key) == false){
            map.set(key, 1);
        }else{
            map.set(key, map.get(key) + 1);
        }
    }
    
    for([key, count] of map){
        if(count > 1) {
            // print(list);
            // console.log(key)
            result++;
        }
    }
    return result;
}

function move(points, list){
    // console.log("--------- MOVE START ---------")
    for(robot of list){
        // 이미 종점 혹은 도착지에 있는 경우, 움직이지 않는다.
        if(robot.arrive > 0) continue;
        if(robot.pos[0] == robot.dest[0] 
          && robot.pos[1] == robot.dest[1]) continue;
        
        // console.log("robot start from ", robot.pos[0], robot.pos[1]);
        if(robot.pos[0] != robot.dest[0]){
            if(robot.dest[0] > robot.pos[0]) robot.pos[0] += 1;
            else robot.pos[0] -= 1;
        } else{
            if(robot.dest[1] > robot.pos[1]) robot.pos[1] += 1;
            else robot.pos[1] -= 1;
        }
        // console.log("robot arrive to ", robot.pos[0], robot.pos[1]);
    }
}

function getArrive(points, list){
    for(robot of list){
        if(robot.arrive == 2) continue;
        if(robot.pos[0] == robot.dest[0] 
          && robot.pos[1] == robot.dest[1]
          ) {
            if(robot.route.length == 0)
                robot.arrive++;
            else
                robot.setNextDest();
        }
    }
}

function print(list){
    for(x of list) console.log(x)
}

function solution(points, routes) {
    let answer = 0;
    let list = [];
    
    for(let x of routes){
        list.push(new Robot(points, x));
    }

        // print(list)
    
    while(isAllArrive(list) == false){
        // 충돌처리
        answer += countCrush(()=> print(list), list)
        // 이동
        move(points, list);
        // 다음 목적지 설정 및 귀가 처리
        getArrive(points, list);
        // print(list)
   
    }
    
    return answer;
}