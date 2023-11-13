# include <iostream>
using namespace std;


/*
식 
N= 3일때 : 표의 위쪽 좌우 대각선의 합임

예를들어 n=2이면
    7
8 
    9

n=3이면

        6
    7
        8
8       
        8
    9

= 자기보다 1큰수, 1작은수의  n-1길이의 계단수의 합

재귀식
dp[n][a] = dp[n-1][a-1] + dp[n-1][a+1]
n : 자리수
a : 시작 숫자
basecase 
dp[1][a] = 1 
dp[n][0] = 1
dp[n][10]= 0
*/
int main()
{
    int n ;
    cin >> n;
    int dp[n+1][10];
    //basecase
    for(int i = 0; i<10; i++)
    {
        dp[1][i] = 1;
    }
    for(int i = 2; i<=n; i++)
    {
        for(int j = 0; j<=9; j++)
        {   
            // 0일때는 뒤에 1밖에 못옴 (나중에 계산에서는 빠짐)
            if (j == 0)
            {
                dp[i][j] = dp[i-1][j+1]%1000000000;
            }
            // 9일때는 뒤에 8밖에 못옴
            else if (j == 9)
            {
                dp[i][j] = dp[i-1][j-1]%1000000000;
            }
            else{
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
            }
            
        }
    }
    int sum = 0;
    for (int i = 1; i<=9; i++)
    {
        sum = (sum + dp[n][i])%1000000000;
    }
    cout << sum << endl;
}