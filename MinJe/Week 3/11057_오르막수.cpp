#include <iostream>
using namespace std;
#define MAX 1001
int dp[10][MAX];

int main(){
    int n;
    cin >> n;

    // dp 배열 초기화
    for (int i = 0; i < 10; i++){
        for (int j = 1; j <= n; j++){
            dp[i][j] = 0;
        }
    }

    // base case (수의 길이가 1)
    for (int i = 0; i < 10; i++){
        dp[i][1] = 1;
    }

    for (int length = 2; length <=n; length++){
        for (int lastNum = 0; lastNum < 10; lastNum++){
            for (int previousNum = 0; previousNum <= lastNum; previousNum++){
                dp[lastNum][length] = (dp[lastNum][length] + dp[previousNum][length-1]) % 10007;
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < 10; i++){
        ans = (ans + dp[i][n]) % 10007;
    }

    cout << ans;
}