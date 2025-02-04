function solution(myStr) {
    const list = myStr.split(/[abc]/).filter((x) => x.length > 0);
    return list.length === 0 ? ["EMPTY"] : list;
}