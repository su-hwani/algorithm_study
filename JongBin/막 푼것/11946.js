const fs = require('fs');
// const stdin = fs.readFileSync('JongBin/막 푼것/index.txt').toString().split('\n');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');

let firstline = stdin[0].split(' ');
let N = parseInt(firstline[0]);
let M = parseInt(firstline[1]);

for(let i = 1 ; i<=N;i++){
    console.log(stdin[i].split("").reverse().join(""));
}