# include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    // n*n 배열을 만들어서 삼각형 값 받기
    int arr[n][n];
    for (int i = 0; i<n; i++)
    {
        for (int j = 0; j<=i; j++)
        {
            cin >> arr[i][j];
        }
    }
    // 각 자리에 덧샘의 최대값을 저장
    // 최대값은 바로위 (dp[i-1][j]), 왼쪽 대각선(dp[i-1][j-1])에있는 최대값 + 자기자신
    int dp[n][n];
    // base case
    dp[0][0] = arr[0][0];
    for (int i = 1; i<n; i++)
    {
        for (int j =0 ; j<=i; j++)
        {   
            //왼쪽 끝이면 선택권이 없이 바로 위의 값만 더해줌
            if( j== 0 )
            {
                dp[i][j] = dp[i-1][j] + arr[i][j];
            }
            //오른쪽 끝이면 선택권 없이 왼쪽위 대각선의 값을 더해줌 
            else if (j == i)
            {
                dp[i][j] = dp[i-1][j-1] + arr[i][j];
            }
            //그 외는 바로위, 왼쪽 대각선중 가장 큰 값을고르고 자기자신을 더함 
            else
            {
                dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
            }
        }
    }
    //마지막 줄에서 가장 큰 값을 출력
    int maxNum =0;
    for (int i = 0; i<n; i++)
    {
        if (dp[n-1][i] > maxNum)
        {
            maxNum = dp[n-1][i];
        }
    }
    cout << maxNum << endl;
}