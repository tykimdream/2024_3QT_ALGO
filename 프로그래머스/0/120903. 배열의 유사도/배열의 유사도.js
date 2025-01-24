function solution(s1, s2) {
    return s1.filter((e) => s2.indexOf(e) !== -1).length;
}