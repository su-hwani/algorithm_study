#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int info[n][2];
    for (int i = 0; i<n; i++)
    {
        cin >> info[i][0] >> info[i][1];
    }
    int dp[501];
    for (int i = 0; i<501; i++)
    {
        dp[i] = 1;
    }
    
    for (int i = 0; i<n; i++)
    {
        for (int j = 0; j<i; j++)
        {
            if (info[i][1] > info[j][1] && dp[i] < dp[j] + 1)
            {
                dp[i] = dp[j] + 1;
            }
        }
    }
    int max = 0;
    for (int i = 0; i<n; i++)
    {
        if (dp[i] > max)
        {
            max = dp[i];
        }
    }
    cout << n - max;
}