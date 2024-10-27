const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    let answer = '';
    for(char of str){
        answer += char === char.toUpperCase() ? 
                 char.toLowerCase() : 
                 char.toUpperCase();
    }
    console.log(answer);
});