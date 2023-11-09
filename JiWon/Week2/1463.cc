#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;

    int D[n+1] = {};
    D[1] = 0;
 
    for(int i = 2; i < n+1; i++){
    /* 세 가지 방법 중 가장 적은 횟수를 사용하는 방법을 저장 */
        D[i] = D[i-1] + 1;
        if(i%2 == 0) D[i] = min(D[i], D[i/2]+1);
        if(i%3 == 0) D[i] = min(D[i], D[i/3]+1);
    }

    cout << D[n];
    return 0;
}
