#include <iostream>
using namespace std;

// dp[i][0] = 팰린드롬 검사 수
// dp[i][1] = 증감 판단
int main()
{   
    string input;
    int inputlen = input.length();
    int arr[inputlen+1];
    int dp[inputlen+1][2];

    for (int i = 0 ; i < inputlen ; i++)
    {
        arr[i] = input[i]-'0';
    }

    dp[0][0] = 0;
    dp[0][1] = 1;

    dp[1][0] = 1;
    dp[1][1] = 1;

    for (int i = 2 ; i <= inputlen ; i++)
    {
        if (dp[i-1][1]==1)
        {
            if (arr[i] == arr[i-1])
            {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = -3;
            }
            else if (arr[i] == arr[i-2])
            {
                dp[i][0] = dp[i-1][0]-1;
                dp[i][1] = -4;
            }
        }
        else if (dp[i][1]==0)
        {
            if (arr[i] == arr[i-1])
            {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = 0;
            }
            else if (arr[i] == arr[i-1]+1)
            {
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = 0;
            }
            else if (arr[i] == arr[i-1]-1)
            {
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = 0;
            }
        }
    }
}