const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    const size = Number(input[0])
    
    for(let i = 0; i < size; i++){
        let line = '';
        for(let j = 0; j <= i; j++) line += '*';
            console.log(line)
        line = '';
    }
});