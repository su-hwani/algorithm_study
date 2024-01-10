const tree = {};

const preorder = (node) => {
	if (node != '.') {
		process.stdout.write(node);
		preorder(tree[node][0]);
		preorder(tree[node][1]);
	}
};

const inorder = (node) => {
	if (node != '.') {
		inorder(tree[node][0]);
		process.stdout.write(node);
		inorder(tree[node][1]);
	}
};

const postorder = (node) => {
	if (node != '.') {
		postorder(tree[node][0]);
		postorder(tree[node][1]);
		process.stdout.write(node);
	}
};

const sol = (input) => {
	input.map((value, idx) => {
		const nodes = value.split(' ');
		tree[nodes[0]] = [nodes[1], nodes[2]];
	});
	preorder('A');
	console.log();
	inorder('A');
	console.log();
	postorder('A');
	console.log();
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
