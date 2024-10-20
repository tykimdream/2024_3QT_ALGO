function solution(word) {
  const dic = []
  const mo = ['A', 'E', 'I', 'O', 'U'];

  function dfs(word, len) {
    if (len > 5) return;
    dic.push(word);

    for (let i = 0; i < 5; i++) {
      dfs(word + mo[i], len + 1);
    }
  }

  dfs("", 0);
  return dic.indexOf(word);
}

