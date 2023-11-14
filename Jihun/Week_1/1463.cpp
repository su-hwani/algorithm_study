#include <iostream>
using namespace std;

int findMin(int n) {
    int *memo = new int[n + 1];
    memo[1] = 0;

    for (int i = 2; i <= n; i++) {
        memo[i] = memo[i - 1] + 1;
        if (i % 2 == 0)
            memo[i] = min(memo[i], 1 + memo[i / 2]);
        if (i % 3 == 0)
            memo[i] = min(memo[i], 1 + memo[i / 3]);
    }

    return memo[n];
}

int main() {
    int n;
    cin >> n;
    cout << findMin(n) << endl;

    return 0;
}