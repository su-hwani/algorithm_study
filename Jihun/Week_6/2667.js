let visited;
let arr;
const dx = [0, 1, 0, -1];
const dy = [-1, 0, 1, 0];
let house = 0;
let N = 0;

const dfs = (i, j) => {
	visited[i][j] = 1;
	arr[i][j] = 0;
	house++;
	for (let k = 0; k < 4; k++) {
		const nx = i + dx[k];
		const ny = j + dy[k];
		if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
			if (arr[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
};

const sol = (input) => {
	N = parseInt(input[0]);
	arr = new Array(N).fill(0).map(() => new Array(N));
	visited = new Array(N).fill(0).map(() => new Array(N).fill(0));
	for (let i = 0; i < N; i++) {
		const numbers = input[i + 1];
		for (let j = 0; j < N; j++) {
			arr[i][j] = parseInt(numbers[j]);
		}
	}

	let count = 0;
	const houses = [];
	for (let i = 0; i < N; i++) {
		for (let j = 0; j < N; j++) {
			if (arr[i][j] == 1) {
				count++;
				dfs(i, j);
				houses.push(house);
				house = 0;
			}
		}
	}
	console.log(count);
	houses.sort((x, y) => x - y);
	houses.map((item) => console.log(item));
};

const input = [];
require('readline')
	.createInterface(process.stdin, process.stdout)
	.on('line', (line) => {
		input.push(line);
	})
	.on('close', () => {
		sol(input);
		process.exit();
	});
