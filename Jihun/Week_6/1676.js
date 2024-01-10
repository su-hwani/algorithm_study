const factorial = (n) => {
	let result = 1;
	let zeroCount = 0;

	for (let i = 1; i <= n; i++) {
		result = result * i;
		while (result % 10 == 0) {
			result = result / 10;
			zeroCount++;
		}
		result %= 1000;
	}

	return zeroCount;
};

const sol = (input) => {
	console.log(factorial(input));
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
