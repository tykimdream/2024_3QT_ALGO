function solution(participant, completion) {
    const runner = {}
    
    for(name of participant){
        runner[name] = (runner[name] || 0) + 1;
    }
    
    for(name of completion){
        runner[name]--;
    }
    
    for(name of participant){
        if(runner[name] == 1) return name;
    }
    
}