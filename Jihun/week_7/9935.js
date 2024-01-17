const sol = (input) => {
	let str = input[0];
	const bomb = input[1];

	const stack = new Array(str.length).fill('');
	const bomLen = bomb.length;
	let idx = 0;
	let flag = false;

	for (let i = 0; i < str.length; i++) {
		stack[idx] = str[i];

		if (stack[idx] === bomb[bomLen - 1] && idx >= bomLen - 1) {
			flag = true;
		}

		if (flag) {
			for (let j = 0; j < bomLen; j++) {
				if (stack[idx + j - bomLen + 1] !== bomb[j]) {
					flag = false;
				}
			}
			if (flag) {
				idx -= bomLen - 1;
				continue;
			}
		}
		idx++;
	}

	str =
		stack.slice(0, idx).join('') === ''
			? 'FRULA'
			: stack.slice(0, idx).join('');
	console.log(str);
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
