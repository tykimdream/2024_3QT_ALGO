function solution(targets) {
    let answer = 0;
    targets.sort((a, b) => a[1] - b[1])
    
    // 모든 미사일이 격추되어야한다.
    let shootingPoint = -1;
    
    for(const [start,end] of targets){
        if(shootingPoint <= start){
            shootingPoint = end
            answer++;
        }
    }
    
    return answer;
}