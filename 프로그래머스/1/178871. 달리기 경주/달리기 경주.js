function solution(players, callings) {
    let nameMap = new Map();
    let rankMap = new Map();
    
    for(let i = 0; i < players.length; i++){
        nameMap.set(players[i], i + 1);
        rankMap.set(i + 1, players[i]);
    }
    
    for(let chaserName of callings){
        let chaserRank = nameMap.get(chaserName);
        
        // chaser - 1인 친구랑 랭크, 이름을 바꾼다.
        let catchedName = rankMap.get(chaserRank - 1);
        let catchedRank = nameMap.get(catchedName);
        
        // nameMap에서는
        // chaserName의 rank -1
        // catchedName의 rank +1
        nameMap.set(chaserName, chaserRank - 1);
        nameMap.set(catchedName, catchedRank + 1)
        
        // rankMap에서는
        // chaserRank = catchedName
        // catchedRank = chaserName
        rankMap.set(chaserRank, catchedName);
        rankMap.set(catchedRank, chaserName);
    }
    
    return [...rankMap.values()];
}