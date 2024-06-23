const fs = require('fs');
const stdin = fs.readFileSync('JongBin/막 푼것/index.txt').toString().split('\n');
// const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
let N = stdin[0];
let have = [];
let arr = stdin[1].split(" ");
for(let i = 0; i <N;i++){
    if(have[arr[i]] === undefined){
        have[arr[i]] = 0;
    }
    have[arr[i]]++;
}
let M =stdin[2];
let answer="";
let checkarr = stdin[3].split(" ");
for(let i = 0; i<M;i++){
    if(have[checkarr[i]] === undefined){
        answer += "0 ";}
        else{
            answer += have[checkarr[i]]+" ";
        }
    
}
console.log(answer);