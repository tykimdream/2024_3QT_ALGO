function solution(arr) {
    const stack = [];
    arr.map((value, index) =>{
        if(stack.length === 0) {
            stack.push(value)
            return;
        }
        if(stack[stack.length - 1] == value) {
            stack.pop();
            return;
        }else{
            stack.push(value);
        }
    })
    
    return stack.length === 0 ? [-1] : stack;
}