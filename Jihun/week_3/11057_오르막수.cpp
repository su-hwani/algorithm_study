#include <iostream>
using namespace std;

int main() {
    int n, temp, sum;
    cin >> n;
    int arr[1001][11];

    // 길이가 1일 때 초기화
    for (int i = 0; i <= 10; i++)
        arr[1][i] = 1;
    // 9로 시작할 때 초기화
    for (int i = 1; i <= n; i++)
        arr[i][9] = 1;

    for (int i = 2; i <= n; i++) {
        sum = 0;
        for (int j = 8; j >= 0; j--) {
            sum += arr[i][j] = (arr[i][j + 1] + arr[i - 1][j]) % 10007;
        }
    }

    cout << (sum + 1) % 10007 << endl;

    return 0;
}
