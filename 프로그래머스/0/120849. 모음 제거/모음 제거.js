function solution(my_string) {
  const mo = ['a', 'e', 'i', 'o', 'u']
  let answer = '';

  [...my_string].forEach((e) => {
    if (mo.includes(e) === false) answer += e
  })
  return answer;
}