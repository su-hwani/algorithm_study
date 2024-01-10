const sol = (input) => {
	let arr = input[0].split('');
	let cursor = arr.length;
	const M = parseInt(input[1]);

	for (let i = 0; i < M; i++) {
		[com, param] = input[i + 2].split(' ');
		if (com === 'L') {
			cursor = cursor - 1 >= 0 ? cursor - 1 : 0;
		} else if (com === 'D') {
			cursor = cursor + 1 <= arr.length ? cursor + 1 : arr.length;
		} else if (com === 'B') {
			if (cursor != 0) {
				arr.splice(cursor - 1, 1);
				cursor = cursor - 1 >= 0 ? cursor - 1 : 0;
			}
		} else {
			arr.splice(cursor, 0, param);
			cursor = cursor + 1 <= arr.length ? cursor + 1 : arr.length;
		}
	}

	return arr.join('');
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
