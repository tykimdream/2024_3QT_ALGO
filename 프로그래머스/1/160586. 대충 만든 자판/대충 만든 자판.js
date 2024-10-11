function solution(keymap, targets) {
    var answer = [];
    let maps = [];
    
    for(let key of keymap){
        let map = new Map();
        for(let i = 0; i < key.length; i++){
            if(map.has(key.charAt(i))) continue;
            map.set(key.charAt(i), i + 1);
        }
        maps.push(map)
    }

    for(let target of targets){
        let count = 0;
        let ch_num = Infinity;
        
        for(let i = 0; i < target.length; i++){
            let ch = target.charAt(i);
            ch_num = Infinity;
            for(let map of maps){
                if(map.get(ch) < ch_num) ch_num = map.get(ch)
            }
            if(ch_num == Infinity) {
                count = -1;
                break;
            }
            count += ch_num
        }
        answer.push(count);
    }
    
    return answer;
}