function solution(gems) {
    const gemTypes = new Set(gems).size;
    const counter = {};
    const len = gems.length;
    
    let start = 0, currentTypes = 0;
    let answer = [1, len];
    
    gems.forEach((gem, end) =>{
        if(!counter[gems[end]]){
            currentTypes++;
        }
        
        counter[gems[end]] = (counter[gems[end]] || 0) + 1;
        
        while(currentTypes === gemTypes){
            if(end - start < answer[1] - answer[0]){
                answer = [start + 1, end + 1];
            }
            
            counter[gems[start]]--;
            if(counter[gems[start]] === 0){
                currentTypes--;
            }
            start++;            
        }
        
    })
    
    return answer;
}