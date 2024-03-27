#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int people[50001];
int totalPeople[50001];
int dp[50001][3];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++){
        cin >> people[i];
    }
    cin >> m;

    for (int i = m; i <= n; i++){
        for (int j = i-m+1; j <= i; j++){
            totalPeople[i] += people[j];
        }
    }
    
    int answer = 0;

    // base case
    dp[m][1] = totalPeople[m];
    dp[m][2] = 0;
    dp[m][3] = 0;

    for (int i = m+1; i <= n; i++){
        // 첫 번째 객차의 max 판단
        dp[i][1] = max(dp[i-1][1], totalPeople[i]);
        // 두 번째 객차의 max 판단
        if (2*m <= i){
            dp[i][2] = max(dp[i-1][2], dp[i-m][1]+totalPeople[i]);
        }
        // 세 번째 객차의 max 판단
        if (3*m <= i){
            dp[i][3] = max(dp[i-1][3], dp[i-m][2]+totalPeople[i]);
            answer = max(answer, dp[i][3]);
        }
    }

    cout << dp[n][3] << endl;


}