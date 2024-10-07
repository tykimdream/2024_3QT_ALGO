function solution(h1, m1, s1, h2, m2, s2) {
    var answer = 0;
    
    let start = h1 * 3600 + m1 * 60 + s1;
    let end = h2 * 3600 + m2 * 60 + s2;
    
    if(start == 0 || start == 12 * 3600) answer++;
    
    while(start < end){
        let curSecAngle = start * 6 % 360;
        let curMinAngle = start / 10 % 360;
        let curHourAngle = start / 120 % 360;
        
        const nextHourAngle = ((start + 1) / 120) % 360 === 0 ? 360 : ((start + 1) / 120) % 360;
        const nextMinAngle = ((start + 1) / 10) % 360 === 0 ? 360 : ((start + 1) / 10) % 360;
        const nextSecAngle = ((start + 1) * 6) % 360 === 0 ? 360 : ((start + 1) * 6) % 360;
        
        if(curSecAngle < curMinAngle && nextSecAngle >= nextMinAngle){
            answer++;
        }
        if(curSecAngle < curHourAngle && nextSecAngle >= nextHourAngle){
            answer++;
        }
        if(nextSecAngle == nextMinAngle && nextSecAngle == nextHourAngle)
            answer--;
        
        start++;
    }
    
    return answer;
}