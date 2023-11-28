#include <iostream>
using namespace std; 
#define max3(a,b,c) (a>b?(a>c?a:c):(b>c?b:c))
#define max2(a,b)( a>=b?(a):(b))

// 왼쪽떄거나, 오른쪽떄거나, 안때거나.
// dp[0][n]왼쪽
// dp [1][n]둘다안떔
// dp[2][n]오른쪽 

int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int n;
        cin >> n;
        int arr[2][n+1];
        int dp[3][n+1];
        for(int i=0; i<2; i++)
        {
            for(int j=1; j<=n; j++)
            {
                cin >> arr[i][j];
            }
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[2][0] = 0;
        dp[0][1] = arr[0][1];
        dp[1][1] = 0;
        dp[2][1] = arr[1][1];
        for(int i=2; i<=n; i++)
        {
            dp[0][i] = max2(dp[1][i-1], dp[2][i-1]) + arr[0][i];
            dp[1][i] = max3(dp[0][i-1], dp[1][i-1], dp[2][i-1]);
            dp[2][i] = max2(dp[0][i-1], dp[1][i-1]) + arr[1][i];
            
            // dp[0][i] = max2(dp[1][i-1], dp[1][i-1]) + arr[0][i];
            // dp[0][i] = max2(dp[1][i-1], dp[1][i-2]) + arr[1][i];
            
        }
        cout << max(dp[0][n], dp[2][n]) << endl;
    }
}

