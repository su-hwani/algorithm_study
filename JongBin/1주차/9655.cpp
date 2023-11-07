# include <iostream>
using namespace std;

// base case
// 0 : 0
// 1 : 1
// 2 : 2
// 3 : 1
// 4 : 2
// 5 : 3 

// 돌을 1 또는 3개를 가져올 수 있으므로 
// n번째 : min(n-1,n-3)+1 번이 됨.

int main()
{
    int n;
    cin >>n;
    int dp[1001];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i<=n; i++)
    {
        dp[i] = min(dp[i-1],dp[i-3])+1;
    }
    if (dp[n]%2==0){
        cout << "CY"<<endl;
    } else cout << "SK"<<endl;
}