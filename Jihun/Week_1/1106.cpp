#include <iostream>
using namespace std;

int main() {
    int C, N;
    cin >> C >> N;
    int *cost = new int[N];
    int *customer = new int[N];
    int *dp = new int[C + 1];
    dp[0] = 0;

    for (int i = 0; i < N; i++) {
        cin >> cost[i] >> customer[i];
    }

    for (int i = 1; i <= C; i++) {
        // 아무거나 주어진 데이터로 답이 되는 값을 넣기 위해.
        // INT_MAX 넣으면 overflow
        dp[i] = ((C / customer[0]) + 1) * cost[0];

        for (int j = 0; j < N; j++) {
            if (i - customer[j] >= 0)
                dp[i] = min(dp[i], dp[i - customer[j]] + cost[j]);
            else
                dp[i] = min(dp[i], cost[j]);
        }
    }
    cout << dp[C] << endl;

    return 0;
}