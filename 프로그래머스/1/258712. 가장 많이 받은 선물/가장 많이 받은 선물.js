function solution(friends, gifts) {
    let len = friends.length;
    let map = new Map();
    let numToName = new Map();
    // 다음 달에 받을 선물 수
    let nextMap = new Map();
    // 선물 지수 저장
    let indexMap = new Map();
    
    for(let i = 0; i < len; i++){
        map.set(friends[i], i);
        numToName.set(i, friends[i]);
        nextMap.set(friends[i], 0);
        indexMap.set(friends[i], 0);
    }
    
    let arr = Array(len).fill().map((e)=> Array(len).fill(0));
    let gifted = Array(len).fill().map((e)=> Array(len).fill(false));
    
    for(name of gifts){
        let [from, to] = name.split(" ");
        arr[map.get(from)][map.get(to)]+= 1;
    }
    
    // 선물 지수 계산
    for(let i = 0; i < len; i++){
        let give = 0;
        let get = 0;
        for(let j = 0; j < len; j++){
            give += arr[i][j];
            get += arr[j][i];
        }
        indexMap.set(friends[i], give - get);
    }
    
    // console.log(arr)
    // console.log("===========")
    // console.log(indexMap)
    for(let i = 0; i < len; i++){
        for(let j = 0; j < len; j++){
            if(i == j) continue;
            if(gifted[i][j] == false && gifted[j][i] == false){
                let from = numToName.get(i);
                let to = numToName.get(j);
                
                // 선물 주고 받기 실행
                // 주고 받은 기록이 있다면
                if(arr[i][j] != arr[j][i]){
                    // console.log(i, j)
                    // console.log(gifted)
                    if(arr[i][j] > arr[j][i]){
                        nextMap.set(from, nextMap.get(from) + 1);
                    } else
                        nextMap.set(to, nextMap.get(to) + 1);
                }
                // 주고 받은 기록이 없고나 주고받은 수가 같다면
                if((arr[i][j] == 0 && arr[j][i] == 0) || arr[i][j] == arr[j][i]){
                    // 선물 지수 비교
                    // console.log("index compare")
                    let iIndex = indexMap.get(from);
                    let jIndex = indexMap.get(to);
                    // console.log(iIndex, jIndex);
                    if(iIndex > jIndex){
                        nextMap.set(from, nextMap.get(from) + 1);
                    } else if(iIndex < jIndex){
                        nextMap.set(to, nextMap.get(to) + 1);
                    }
                }
                // console.log([...nextMap])
                // console.log("==========")
                gifted[i][j] = gifted[j][i] = true;
            }
            
        }
    }
    
    return Math.max(...nextMap.values());
}