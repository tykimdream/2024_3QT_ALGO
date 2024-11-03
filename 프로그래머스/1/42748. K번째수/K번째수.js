function solution(array, commands) {
    var answer = [];
    return commands.map((com) =>array.slice(com[0] - 1, com[1]).sort((a, b) => a - b)[com[2] - 1]);
}