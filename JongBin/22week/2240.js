const fs = require('fs');
// const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
const stdin = fs.readFileSync('JongBin/22week/index.txt').toString().trim().split('\n');

let [T,W] = stdin.shift().split(" ").map(Number);
const tree = Array(T+1);
for(let i = 1; i<=T; i++){
    tree[i] = +stdin.shift();
}
let post =1; 
const dp = Array(T+1).fill().map(()=>Array(W+1).fill(0));
let answer = 0;
for(let t = 1; t<=T;t++){
    const treePosition = tree[t];
    for(let w = 0; w<=W; w++){
        if(w==0){
            post = 1;
            if(treePosition == post){
                dp[t][w] = dp[t-1][w]+1;
            }
            else{
                dp[t][w] = dp[t-1][w];
            }
            continue;
        }
        if(w%2==0){
            post =1;
            if(treePosition == post){
                dp[t][w] = Math.max(dp[t-1][w]+1, dp[t-1][w-1]);
            }else{
                dp[t][w] = Math.max(dp[t-1][w-1]+1, dp[t-1][w]);
            }
        }else{
            post = 2;
            if(treePosition == post){
                dp[t][w] = Math.max(dp[t-1][w]+1, dp[t-1][w-1]);
            }
            else{
                dp[t][w] = Math.max(dp[t-1][w-1]+1, dp[t-1][w]);
            }
        }
        answer = Math.max(answer, dp[t][w]);
    }    
}
console.log(answer);