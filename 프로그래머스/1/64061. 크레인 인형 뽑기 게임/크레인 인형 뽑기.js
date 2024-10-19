function solution(board, moves) {
  var answer = 0;
  let stack = [];
  for (move of moves) {
    for (let i = 0; i < board[move - 1].length; i++) {
      if (board[i][move - 1] != 0) {
        stack.push(board[i][move - 1]);
        board[i][move - 1] = 0;
        break;
      }
    }
    while (stack.length > 1 && stack[stack.length - 1] == stack[stack.length - 2]) {
      stack.pop();
      stack.pop();

      answer += 2;
    }
  }
  return answer;
}