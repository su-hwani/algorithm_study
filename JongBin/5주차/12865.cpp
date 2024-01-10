#include <iostream>
using namespace std;

int main()
{
    // int n, k ;
    // cin >> n >> k;
    // int w[n][2];

    // // w[i][0] = 무게 , w[i][1] = 가치
    // for (int i = 0 ; i < n ; i++)
    // {
    //     cin >> w[i][0] >> w[i][1];
    // }
    // int dp[k+1];
    // for (int i = 0 ; i <= k ; i++)
    // {
    //     dp[i] = -1;
    // }

    // for (int i = 0; i < n ; i++)
    // {
    //     dp[w[i][0]] = w[i][1];   
    // }

    // for (int i=1; i<=k ; i++)
    // {
    //     for (int j = 0; j<n; j++)
    //     {
    //         if (i-w[j][0] >= 0)
    //         {
    //             dp[i] = max(dp[i], dp[i-w[j][0]]+w[j][1]);
    //         }
    //     }
    // }


    // cout << dp[k] << endl;
    int N,K;
    cin >> N >> K;
    int DP[N+1][K+1];
    int W[N+1];
    int V[N+1];
    for (int i = 0 ; i <= N ; i++)
    {
        for (int j = 0 ; j <= K ; j++)
        {
            DP[i][j] = 0;
        }
    }

	for (int i = 1; i <= N; i++)
		cin >> W[i] >> V[i];

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= K; j++)
		{
			 
			 if (j - W[i] >= 0) DP[i][j] = max(DP[i - 1][j], DP[i - 1][j - W[i]] + V[i]);
			 else DP[i][j] = DP[i - 1][j];
		}
	}

	cout << DP[N][K];

}