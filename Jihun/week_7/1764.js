const sol = (input) => {
	const a = input[0].split(' ').map(Number)[0];
	const set1 = new Set(input.slice(1, a + 1));
	const set2 = new Set(input.slice(a + 1));
	const intersection = new Set([...set1].filter((value) => set2.has(value)));

	const arr = [...intersection];
	arr.sort();
	console.log(intersection.size);
	for (const name of arr) {
		console.log(name);
	}
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
