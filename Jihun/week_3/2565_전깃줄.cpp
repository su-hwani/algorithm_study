#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    int *dp = new int[n];
    vector<pair<int, int>> lines(n);
    for (int i = 0; i < n; i++) {
        cin >> lines[i].first >> lines[i].second;
    }

    sort(lines.begin(), lines.end());

    dp[0] = 1;
    for (int i = 1; i < n; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (lines[i].second > lines[j].second) {
                dp[i] = max(dp[j] + 1, dp[i]);
            }
        }
    }

    int max2 = dp[0];
    for (int i = 0; i < n; i++)
        max2 = max(max2, dp[i]);

    cout << n - max2 << endl;

    return 0;
}
