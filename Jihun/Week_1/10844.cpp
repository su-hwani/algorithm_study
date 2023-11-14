#include <iostream>
using namespace std;

const long long M = 1000000000;

int main() {
    long long dp[101][10];

    int n;
    cin >> n;
    for (int i = 1; i <= 9; i++) {
        dp[0][i] = 1;
    }
    for (int i = 1; i <= 9; i++) {
        dp[1][i] = 1;
    }
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= 9; j++) {
            if (j - 1 == 0) {
                dp[i][j] = (dp[i - 2][j] + dp[i - 1][j + 1]) % M;
            } else if (j + 1 == 10) {
                dp[i][j] = dp[i - 1][j - 1] % M;
            } else {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % M;
            }
        }
    }

    long long result = 0;
    for (int i = 1; i <= 9; i++) {
        result = (result + dp[n][i]) % M;
    }
    cout << result % M << endl;

    return 0;
}