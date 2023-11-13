# include <iostream>
# include <climits>
using namespace std;
#define MIN(a,b,c) ((a<b)?((a<c)?a:c):((b<c)?b:c))
/*
x % 3 ==0 일때 /3
x % 2 ==0 일때 /2
둘다 아니면 -1

basecase : 1일때 0
*/

/*
1 : 0
2 : 1
3 : 1
4 : 2
5 : 3
6 : 2
7 : 3

=> min (n-1,n/2,n/3) +1

*/
int main()
{
    int n;
    cin >> n;
    int dp[n+1];
    //basecase
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i<=n; i++)
    {   
        //-1은 어디서나 가능하지만 나누기들은 조건이 있음
        // 조건에 만족하지 않으면 선택되지 않게 INT_MAX로 초기화
        // 값검사를안하면 원하는 값 안나옴
        int a = INT_MAX;
        int b = INT_MAX;
        if (i%3 == 0)
        {
            a = dp[i/3];
        }
        if (i%2 == 0)
        {
            b = dp[i/2];
        }
        
        dp[i] = MIN(dp[i-1],a,b)+1;
    }
    cout << dp[n]<<endl;
}