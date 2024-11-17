const path = require("path");

let input =
  process.platform === "linux"
    ? require("fs").readFileSync("/dev/stdin").toString().trim().split("\n")
    : require("fs")
        .readFileSync(path.join(__dirname, `test1.txt`))
        .toString()
        .trim()
        .split("\n");

const [N, K] = input[0].split(" ").map(Number);
const belt = input[1].split(" ").map(Number);
const robots = Array(2 * N).fill(0); // 로봇의 위치를 표시할 배열
let step = 0;
const len = 2 * N;

while (true) {
  step++;

  const lastBelt = belt[len - 1];
  const lastRobot = robots[len - 1];

  for (let i = len - 1; i > 0; i--) {
    belt[i] = belt[i - 1];
    robots[i] = robots[i - 1];
  }

  belt[0] = lastBelt;
  robots[0] = lastRobot;

  robots[N - 1] = 0;

  for (let i = N - 2; i >= 0; i--) {
    if (robots[i] === 1 && robots[i + 1] === 0 && belt[i + 1] > 0) {
      robots[i + 1] = 1;
      robots[i] = 0;
      belt[i + 1]--;
    }
  }
  robots[N - 1] = 0;

  if (belt[0] > 0 && robots[0] === 0) {
    robots[0] = 1;
    belt[0]--;
  }

  const dead = belt.filter((e) => e === 0).length;
  if (dead >= K) break;
}

console.log(step);