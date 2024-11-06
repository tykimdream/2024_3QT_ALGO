'use strict'
function solution(n, times) {
    let start = 1;
    let end = Math.max(...times) * n;
    let answer = end;
    
    while(start < end){
        let mid = Math.floor((start + end) / 2);
        
        // mid 타임동안 통과시킬 수 있는 사람
        let midTimePassenger = 0;
        for(let time of times){
            midTimePassenger += Math.floor(mid / time);
        }
               
        if(midTimePassenger < n) start = mid + 1;
        else {
            answer = Math.min(answer, mid);
            end = mid;
        }
        
    }
    return answer;
}