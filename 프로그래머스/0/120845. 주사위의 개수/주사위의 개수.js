function solution(box, n) {
    return box.reduce((cur, acc) => cur *= parseInt(acc / n), 1);
}