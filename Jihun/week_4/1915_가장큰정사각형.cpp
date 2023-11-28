#include <iostream>
using namespace std;

int min2(int a, int b, int c) { return min(a, min(b, c)); }

int main() {
    int arr[1001][1001];
    int dp[1001][1001];
    int n, m;
    cin >> n >> m;
    int result = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char c;
            cin >> c;
            arr[i][j] = c - '0';
        }
    }
    for (int i = 0; i < n; i++) {
        dp[i][0] = arr[i][0];
        result = max(arr[i][0], result);
    }

    for (int i = 0; i < m; i++) {
        dp[0][i] = arr[0][i];
        result = max(arr[0][i], result);
    }

    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (arr[i][j] == 1)
                dp[i][j] =
                    min2(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1;
            result = max(dp[i][j], result);
        }
    }

    cout << result * result << endl;

    return 0;
}