#include <iostream>
using namespace std;
#define min(a,b,c) (a<b?(a<c?a:c):(b<c?b:c))

// arr[i][j] ==0 이면 dp[i][j]==0
// arr[i][j] ==1
// dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1;
// 
int main()
{
    int n, m;
    cin >> n >> m;
    int arr[n+1][m+1];
    int dp[n+1][m+1];

    for (int i =1 ; i<=n; i++)
    {   string input;
        cin >> input; 
        int inputlen = input.length();
        for (int j = 1 ; j <=m ; j++)
        {
            arr[i][j] = input[j-1]-'0';
        }
    }

    //0 행,열은 초기화 (overflow 방지)
    for(int i=0; i<=n; i++)
    {
        dp[i][0] = 0;
    }
    
    for(int j=0; j<=m; j++)
    {
        dp[0][j] = 0;
    }
    int max = 0;
    for (int i =1 ; i<=n; i++)
    {
        for (int j = 1 ; j <=m ; j++)
        {   if (arr[i][j] == 0)
            {
                dp[i][j] = 0;
            }
            else if (arr[i][j] == 1)
            {
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1;
                if (dp[i][j] > max)
                {
                    max = dp[i][j];
                }
            }
        }
    }
    cout << max*max << endl;
}
