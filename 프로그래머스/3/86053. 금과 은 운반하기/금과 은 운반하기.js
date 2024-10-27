function solution(a, b, g, s, w, t) {
    let len = g.length;
    let start = 0;
    let end = Number.MAX_SAFE_INTEGER
    
    while(start <= end){
        let mid = Math.floor((start + end) / 2);
        
        let totalGold = 0, totalSliver = 0, totalMine = 0;
        // mid 시간 동안, 각 마을에서 가져왔을 때의 최대 값
        for(let i = 0; i < len; i++){
            let count = Math.floor((mid - t[i]) / (t[i] * 2)) + 1;
            if(mid < t[i]) count = 0;
            
            // count * w[i] <- 가져올 수 있는 광물의 총량
            let totalWeight = count * w[i];
        
            totalGold += Math.min(g[i], totalWeight);
            totalSliver += Math.min(s[i], totalWeight);
            totalMine += Math.min(g[i] + s[i], totalWeight)
        }
        if(totalGold >= a && totalSliver >= b && totalMine >= a + b){
            // 충분한 시간이니 시간을 줄여본다.
            end = mid - 1;
        } else{
            start = mid + 1;
        }
        
    }
    return start;
}