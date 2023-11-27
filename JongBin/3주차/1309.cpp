//나중에다시보기
#include <iostream>
using namespace std;

//basecase
// n = 0 => 1
// n=1 => 3
// n=2 => 7 = 1 + 4 + 2
// n=3 => 17 = 1 + 6 + 8 + 2

//recursion
//dp[n] = dp[n-2] + 2*dp[n-1]
// 윗줄에서 하나 쓸때 => 2*dp[n-1] 
// 안쓸때 : dp[n-2]
int main()
{
    int n;
    cin >> n;
    int dp[100001];
    //basecase setting
    dp[0] = 1;
    dp[1] = 3;
    //recursion
    for (int i = 2 ; i <= n ; i++)
    {
        dp[i] = (dp[i-2] + 2*dp[i-1])%9901;
    }
    cout<<dp[n]<<endl;


    // int dp[100001][3];
    // //basecase setting
    // dp[0][0] = 1;
    // dp[0][1] = 1;
    // dp[0][2] = 1;
    // //recursion
    // for (int i = 1 ; i <= n ; i++)
    // {
    //     dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
    //     dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
    //     dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
    // }
    // cout<<(dp[n][0] + dp[n][1] + dp[n][2])%9901<<endl;







    // //basecase setting
    // int **dp= new int*[n+2];
    // for (int i = 0 ; i <= n+1 ; i++)
    // {
    //     dp[i] = new int[n+2];
    // }    
    // for (int i = 0 ; i <= n ; i++)
    // {
    //     dp[i][1] = 2*i;
    //     dp[i][0] = 1;
    //     dp[i][i] = 2;
    // }
    // //recursion
    // for (int i=2; i<=n; i++)
    // {
    //     for (int j = 2; j<i; j++)
    //     {
    //         dp[i][j] = (dp[i-1][j] + (dp[i-1][j-1]-(2*(j-1)-1))*2)%9901;
    //     }
        
    // }
    // int result = 0;
    // for (int i = 0 ; i <=n ; i++)
    // {
    //     result += dp[n][i];
    // }
    // cout<<result%9901<<endl;
    // return 0;



    
}
