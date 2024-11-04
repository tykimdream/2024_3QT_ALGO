function solution(number, k) {
    var answer = '';
    let stack = []
    
    for(let i = 0; i < number.length; i++){
        const cur = number[i];
        
        while(k > 0 && stack.length > 0 && stack[stack.length - 1] < cur){
            stack.pop();
            k--;
        }
        
        stack.push(cur);
    }
    
    while(k > 0){
        stack.pop();
        k--;
    }
    
    
    return stack.join('');
}