let tree, arr;

const buildSegmentTree = (index, start, end) => {
	if (start === end) {
		tree[index] = [arr[start], arr[start]];
		return tree[index];
	}
	const mid = parseInt((start + end) / 2);
	const left = buildSegmentTree(index * 2, start, mid);
	const right = buildSegmentTree(index * 2 + 1, mid + 1, end);
	tree[index] = [Math.min(left[0], right[0]), Math.max(left[1], right[1])];

	return tree[index];
};

const findMinMax = (index, start, end, left, right) => {
	if (left > end || right < start) {
		return [1000000001, 0];
	}
	if (left <= start && right >= end) {
		return tree[index];
	}

	const mid = parseInt((start + end) / 2);
	const left2 = findMinMax(index * 2, start, mid, left, right);
	const right2 = findMinMax(index * 2 + 1, mid + 1, end, left, right);
	return [Math.min(left2[0], right2[0]), Math.max(left2[1], right2[1])];
};

const sol = (input) => {
	const N = input[0].split(' ').map(Number)[0];
	const M = input[0].split(' ').map(Number)[1];

	arr = [];
	arr.push(0);
	for (let i = 0; i < N; i++) {
		arr.push(parseInt(input[i + 1]));
	}

	tree = new Array(N * 4).fill(0);
	buildSegmentTree(1, 1, N);

	for (let i = 0; i < M; i++) {
		[a, b] = input[N + i + 1].split(' ').map(Number);
		[min, max] = findMinMax(1, 1, N, a, b);
		console.log(min, max);
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
