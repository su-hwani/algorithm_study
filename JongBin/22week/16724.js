const fs = require('fs');
// const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const stdin = fs.readFileSync('JongBin/22week/index.txt').toString().trim().split('\n');
let [N,M] = stdin.shift().split(" ").map(Number);
const dx = [0,0,1,-1];
const dy = [1,-1,0,0];
const map = Array(N).fill().map(()=>Array(M));
for(let i = 0; i<N;i++){
    const row = stdin.shift().split("");
    for(let j = 0; j<M;j++){
        const temp = row[j];
        switch(temp){
            case "U":
                map[i][j] = 1;
                break;
            case "D":
                map[i][j] = 0;
                break;
            case "R":
                map[i][j] = 2;
                break;
            case "L":
                map[i][j] = 3;
                break;
        }
    }
}
let count = 0;
let answer = 0;
const visit = Array(N).fill().map(()=>Array(M).fill(-1));
for(let i = 0; i<N;i++){
    for(let j = 0; j<M;j++){
        if(visit[i][j]===-1){
            dfs(i,j,count);
            count++;
        }
    }
}
console.log(answer);

function dfs(y, x,a){
    if(visit[y][x]!=-1){
        if(visit[y][x] === a){
            answer++;
        }
        return
    }
    visit[y][x] = a;
    const dir = map[y][x];
    const nx = x + dx[dir];
    const ny = y + dy[dir];
    if(nx<0 || nx>=M || ny<0 || ny>=N) return true;
    return dfs(ny,nx,a);
}

