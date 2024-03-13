#include <iostream>
#include <algorithm>
using namespace std;
int dp[10001];
int highway[13][3]; // 시작위치, 도착위치, 길이

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, d;
    cin >> n >> d;

    // 지름길 입력 받음
    for (int i = 1; i <= n; i++){
        cin >> highway[i][0] >> highway[i][1] >> highway[i][2];
    }

    // base case 설정
    for (int i = 0; i <= d; i++){
        dp[i] = i;
    }

    // i까지 이동하는 데 걸리는 최소 시간을 조사
    for (int i = 1; i <= d; i++){
        // n개의 지름길을 모두 조사
        for (int j = 1; j <= n; j++){
            if (highway[j][1] == i){ // 지름길의 도착지점이 i라면
                if (dp[i] > dp[highway[j][0]]+highway[j][2]){
                    dp[i] = dp[highway[j][0]]+highway[j][2];
                    // i+1번째 이후의 최소시간을 모두 반영해주는것에 주의
                    for (int k = i+1; k <= d; k++){
                        dp[k] = dp[i]+(k-i);
                    }
                }
            }
        }
    }

    cout << dp[d];
}