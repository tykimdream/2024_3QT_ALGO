function solution(numbers) {
    // 1. 숫자들을 문자열로 변환하여 정렬
    const answer = numbers
        .map(n => n.toString())
        .sort((a, b) => (b + a) - (a + b))
        .join('');
    
    // 2. 예외 처리: 모든 숫자가 0인 경우
    return answer[0] === '0' ? '0' : answer;
}