#include <iostream>
using namespace std;

//basecase
// n=1 -> 1
// dp[n][9] = 1

//recursion
// dp[n][i] = for sum(dp[n-1][i~9])
// 그런데 sum(dp[n-1][i~9]) = dp[n][i+1] + dp[n-1][i]이다(9부터 계산했을때) 

// 편의를위해 n을 1001까지
int dp[1001][10];
int main()
{
    int n;
    cin >> n;
    //basecase setting
    for (int i = 0 ; i < 10 ; i++)
    {
        dp[1][i] = 1;
    }
    for(int i= 1; i<=n; i++)
    {
        dp[i][9] = 1;
    }

    //recursion
    for(int i=2; i<=n;i++)
    {
        for(int j=8; 0<=j; j--)
        {   //나머지만 저장하면 된다
            dp[i][j] = (dp[i-1][j] + dp[i][j+1])%10007;
        }
    }

    int result=0;

    //답구하기 (0으로 시작할 수 있다고 함)
    for (int i = 0 ; i < 10 ; i++)
    {
        result += dp[n][i];
    }
    cout<<result%10007<<endl;
}