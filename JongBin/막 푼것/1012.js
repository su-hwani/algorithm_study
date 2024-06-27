const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
// const stdin = fs.readFileSync('JongBin/막 푼것/index.txt').toString().trim().split('\n');

let testCase = +stdin.shift();
const inputArr = stdin.map((v)=> v.split(' ').map(Number));

let farm = [];
let visited = [];

const dy = [-1,1,0,0];
const dx = [0,0,-1,1];

function dfs(y,x){
    visited[y][x] = true;
    for(let i = 0; i<4;i++){
        let ny = y + dy[i];
        let nx = x + dx[i];
        if(ny>=0 && nx>=0 && ny<visited.length && nx<visited[0].length){
            if(farm[ny][nx]===1 && !visited[ny][nx]){
                dfs(ny,nx);
            }
        }
    }
}

for(let i =0;i<testCase;i++){
    let answer = 0;
    let [M,N,K] = inputArr.shift();
    farm = Array.from(Array(N), () => new Array(M).fill(0));
    visited = Array.from(Array(N), () => new Array(M).fill(false));
    while(K>0){
        K--;
        const[x,y] = inputArr.shift();
        farm[y][x] = 1;
    }
    for(let y = 0;y<N;y++){
        for(let x = 0;x<M;x++){
            if(farm[y][x]===1 && !visited[y][x]){
                dfs(y,x);
                answer++;
            }
        }
    }
    console.log(answer);
}
