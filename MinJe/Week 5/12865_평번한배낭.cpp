#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;
#define N_MAX 101
#define K_MAX 100001
int weight[N_MAX];
int value[N_MAX];
int dp[N_MAX][K_MAX];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, K;
    cin >> N >> K;

    // 1번 물건부터 N번 물건까지 무게와 가치를 저장
    for (int i = 1; i <= N; i++){
        cin >> weight[i] >> value[i];
    }

    // dp 0으로 초기화
    for (int i = 0; i <= N; i++){
        for (int j = 0; j <= K; j++){
            dp[i][j] = 0;
        }
    }

    // i번째 물건의 무게가 j이고 가치가 v일때 dp[i][j] = v로 설정.
    // 이후 무게가 j보다 클 때는 dp로 탐색.
    
    for (int i = 1; i <= N; i++){
        for (int j = 1; j < weight[i]; j++){
            dp[i][j] = dp[i-1][j];
        }
        for (int j = weight[i]; j <= K; j++){
            dp[i][j] = max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
        }
    }

    cout << dp[N][K];

}