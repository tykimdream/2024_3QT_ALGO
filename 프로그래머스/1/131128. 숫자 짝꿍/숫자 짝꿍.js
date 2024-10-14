function solution(X, Y) {
    let answer = '';
    const xNum = Array(10).fill().map((e) => 0);
    const yNum = Array(10).fill().map((e) => 0)
    const union = Array(10).fill().map((e) => 0)
    
    X.split('').forEach((e)=> xNum[e]++);
    Y.split('').forEach((e)=> yNum[e]++);    
    union[0] = 3000000;
    for(let i = 0; i < 10; i++){
        union[i] = Math.min(xNum[i], yNum[i]);
    }
    
    if(union.filter(e => e == 0).length == 10) return "-1"
    
    for(let i = 9; i >= 0; i--){
        if(union[i]){
            answer += i.toString().repeat(union[i]);    
        }
    }
    return answer[0] == "0" ? "0" : answer;   
}