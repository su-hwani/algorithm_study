#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    
    const int MAX = 1001;
    int D[MAX]; // DP 테이블 생성 및 초기값 할당
    D[1] = 1;
    D[2] = 2;
    D[3] = 1;

    for(int i = 4; i <= n; i++){
        D[i] = min(D[i-1] + 1, D[i-3] + 1);
    }

    if(D[n]%2 == 0) cout << "CY";
    else cout << "SK";
    
    return 0;
}
