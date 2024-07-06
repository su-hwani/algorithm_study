const fs = require('fs');
const stdin = fs.readFileSync('/dev/stdin').toString().split('\n');
// const stdin = fs.readFileSync('JongBin/막 푼것/index.txt').toString().trim().split('\n');

let a = stdin[0];
let answer = 0 ;
for(let i = 0; i<a.length;i++){
    if(a[i]==='0'){
        if(i===0){
            continue;
        }
        if(a[i-1]==='1'||a.length!==2){
            answer += 9;
        }
    }
    else{
        answer += +a[i];
    }
}
console.log(answer);