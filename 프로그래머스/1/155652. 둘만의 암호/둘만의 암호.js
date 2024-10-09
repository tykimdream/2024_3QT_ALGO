function solution(s, skip, index) {
    const alphabet = 'abcdefghijklmnopqrstuvwxyz'
    const filteredAlphabet = alphabet.split('').filter((char) => skip.includes(char) == false);

    return s.split('').map((char) =>{
        return filteredAlphabet[(filteredAlphabet.indexOf(char) + index) % filteredAlphabet.length]; 
    }).join('')
    
}