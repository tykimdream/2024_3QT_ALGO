function solution(name) {
    let answer = 0; 
    let moveCount = name.length - 1;
    
    for(let i = 0; i < name.length; i++){
        let upGap = name.charCodeAt(i) - 'A'.charCodeAt(0);
        answer += Math.min(upGap, 26 - upGap);
        
        let nextIndex = i + 1;
        while(nextIndex < name.length && name[nextIndex] === 'A') nextIndex++;
        
         moveCount = Math.min(
            moveCount, 
            2 * i + (name.length - nextIndex),     // 앞에서부터
            i + 2 * (name.length - nextIndex)      // 뒤에서부터
        );
    }
    
    return answer + moveCount;
}