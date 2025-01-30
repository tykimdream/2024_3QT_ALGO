function solution(hp) {
    const general = Math.floor(hp / 5);
    hp = hp - (general * 5)
    const solider = Math.floor(hp / 3);
    hp = hp - (solider * 3)
    const worker = hp
    
    return general + solider + worker;
}