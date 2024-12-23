function solution(spell, dic) {

    return dic.some((word)=>{
        if(word.length !== spell.length) return false;
        
        return spell.every(e => word.includes(e));
    }) ? 1 : 2
}