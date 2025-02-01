function solution(numbers) {
    numbers.sort((a, b)=> a - b)
    let max = numbers[0] * numbers[1]
    numbers.sort((a, b)=> b - a)
    
    return Math.max(numbers[0] * numbers[1], max)
}