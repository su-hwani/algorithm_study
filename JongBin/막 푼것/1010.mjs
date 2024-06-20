const fs = require('fs');
// const stdin = fs.readFileSync('JongBin/막 푼것/index.txt').toString().split('\n');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
let testNum = stdin[0];
let dp = [1];
for(let i = 1; i<=31;i++){
    dp[i] = i*dp[i-1];
}
for(let i = 1;i<=testNum;i++){
    let str = stdin[i].split(' ');
    let m = parseInt(str[0]);
    let n = parseInt(str[1]);
    console.log(Math.round(dp[n]/(dp[n-m]*dp[m])))
}