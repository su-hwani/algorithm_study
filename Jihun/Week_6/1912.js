const sol = (input) => {
	const N = parseInt(input[0]);
	const arr = input[1].split(' ').map(Number);
	const dp = new Array(N);
	dp[0] = arr[0];

	for (let i = 1; i < N; i++) {
		dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
	}

	return Math.max(...dp);
};

const input = [];
require('readline')
	.createInterface(process.stdin, process.stdout)
	.on('line', (line) => {
		input.push(line);
	})
	.on('close', () => {
		console.log(sol(input));
		process.exit();
	});
