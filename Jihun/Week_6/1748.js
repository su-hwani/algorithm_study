const sol = (input) => {
	let result = 0;
	const len = String(input).length;

	for (let i = len - 1; i > 0; i--)
		result += (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
	result += len * (input - Math.pow(10, len - 1) + 1);

	console.log(result);
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
