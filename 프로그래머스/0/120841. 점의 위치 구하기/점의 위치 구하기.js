function solution(dot) {
    const [x, y] = dot;
    const d = (x * y) > 0;
    return d ? (x > 0 ? 1 : 3) : (y > 0 ? 2 : 4)
}