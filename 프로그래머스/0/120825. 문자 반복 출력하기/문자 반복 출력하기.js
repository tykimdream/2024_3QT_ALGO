function solution(my_string, n) {
    return my_string.split('').map((char)=> char.toString().repeat(n)).join('')
}