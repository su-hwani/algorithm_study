#include <iostream>
using namespace std;

int main() {
    int n, c;
    cin >> n;
    int arr[2][100000];
    int dp[2][100000];

    for (int i = 0; i < n; i++) {
        cin >> c;
        for (int j = 0; j < 2; j++)
            for (int k = 0; k < c; k++)
                cin >> arr[j][k];
        // 위에 떼는 경우
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[1][0] + arr[0][1];
        // 아래 떼는 경우
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[0][0] + arr[1][1];

        for (int l = 1; l < c; l++) {
            dp[0][l] = arr[0][l] + max(dp[1][l - 1], dp[1][l - 2]);
            dp[1][l] = arr[1][l] + max(dp[0][l - 1], dp[0][l - 2]);
        }

        cout << max(dp[0][c - 1], dp[1][c - 1]) << endl;
    }

    return 0;
}