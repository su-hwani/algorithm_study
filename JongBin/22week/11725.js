const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const stdin = fs.readFileSync('JongBin/22week/index.txt').toString().split('\n');
let N = +stdin.shift();
const tree = [...Array(N+1)].map(()=>[]);
const edges = stdin.map(v => v.split(" ").map(Number));
edges.forEach(([a,b])=>{
    tree[a].push(b);
    tree[b].push(a);
});
bfs(tree, 1);

let s = ""
for(let i = 2; i<=N;i++){
    s += tree[i].parent + "\n";
}
console.log(s);

function bfs (tree, start){
    const visited = Array(N+1).fill(false);
    const queue = [start];
    visited[start] = true;
    while(queue.length){
        const n = queue.shift();
        for(const v of tree[n]){
            if(!visited[v]){
                queue.push(v);
                visited[v] = true;
                tree[v].parent = n;
            }
        }
    }
}
