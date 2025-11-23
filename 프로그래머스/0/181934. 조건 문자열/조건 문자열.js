function pro(ineq, eq, n, m){
    if(ineq === '>'){
        if(eq === '=') return n >= m;
        else if(eq === '!') return n > m;
    } else if(ineq === '<'){
        if(eq === '=') return n <= m;
        else if(eq === '!') return n < m;
    }
}

function solution(ineq, eq, n, m) {
    return pro(ineq, eq, n, m) ? 1 : 0
}