# include <iostream>
# include <climits>
using namespace std;


int main()
{   
    //늘리고자 하는 인원수
    int c;
    //도시의 개수
    int n;

    cin >> c>>n;
    //도시의 개수 N, [n][0] :비용 , [n][1] : 증가 고객수
    int info[n][2];
    
    for (int i = 0; i<n; i++)
    {
        cin >> info[i][0] >> info[i][1];
    }

    
    //basecase: 늘리고 싶은 인원이 없으면 0
    int dp[c+101];
    for (int i = 1; i<c+101; i++)
    {
        dp[i] = INT_MAX;
    }
    dp[0] = 0;   
    for (int i =0; i<n ;i++)
    {
        dp[info[i][1]] = info[i][0];
    }

    for(int i =0; i<c+101; i++)
    {
        
        for (int j =0; j<n; j++)
        {   int tempindex = i-info[j][1];
            if (tempindex <0 || dp[tempindex] == INT_MAX)
            {
                continue;
            }
            int temp = dp[tempindex]+info[j][0];
            if( temp< dp[i])
            {
                dp[i] = temp;
            }
        }
        
    }
    int min = INT_MAX;
    for (int i = c; i<c+101; i++)
    {
        if (dp[i] < min)
        {
            min = dp[i];
        }
    }
    
    // for(int i =0; i<c; i++)
    // {
    //     cout << dp[i]<<endl;
    // }
    // int min = dp[c];
    // for (int i =0; i<n; i++)
    // {
    //     for (int j =0; j<n; j++)
    //     {   int costtemp =dp[c-info[i][1]]+info[j][0];
    //         if(c-info[i][1]+info[j][1]>=c && costtemp<min)
    //         {
    //             min = costtemp;
    //         }   
    //     }
    // }
    // dp[c] = min;


    cout << min<<endl;
}