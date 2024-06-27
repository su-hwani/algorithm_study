const fs = require('fs');
// const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const stdin = fs.readFileSync('JongBin/막 푼것/index.txt').toString().trim().split('\n');

let arr = [];
let sum= 0;
for(let i = 0; i<5;i++){
    arr.push(+stdin.shift());
    sum += arr[i];
}
arr.sort((a,b)=>a-b);
console.log(sum/5);
console.log(arr[2])