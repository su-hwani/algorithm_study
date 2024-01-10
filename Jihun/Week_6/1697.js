const sol = (input) => {
  [N, K] = input[0].split(" ").map(Number);

  visited = new Array(100001).fill(0);
  const queue = [];
  queue.push([N, 0]);
  visited[N] = 1;

  while (queue.length) {
    [cur, time] = queue.shift();
    if (cur == K) {
      return time;
    } else {
      for (next of [cur + 1, cur - 1, cur * 2]) {
        if (!visited[next] && next >= 0 && next <= 100000) {
          visited[next] = 1;
          queue.push([next, time + 1]);
        }
      }
    }
  }

  bfs(1);
};

const input = [];
require("readline")
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    console.log(sol(input));
    process.exit();
  });
