function solution(n, k) {
    k -= Math.floor(n / 10);
    if(k < 0) k = 0;
    return (12000 * n) + (2000 * k);
}