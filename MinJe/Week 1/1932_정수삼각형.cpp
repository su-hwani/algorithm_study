#include <iostream>
#include <algorithm>
using namespace std;
#define MAX 501
// triangle은 주어진 input을 저장하는 배열
// dp는 삼각형의 최대 합을 저장하는 배열
int triangle[MAX][MAX];
int dp[MAX][MAX];

int main(){
    int n;
    cin >> n;

    for (int i = 0; i < n; i++){
        for (int j = 0; j <= i; j++){
            cin >> triangle[i][j];
        }
    }

    // dp에 첫 번째 원소 입력
    dp[0][0] = triangle[0][0];
    // dp의 다음 원소는 위의 두 원소를 비교하여 큰 값과 그 자리의 triangle값의 합
    for (int i = 1; i < n; i++){
        for (int j = 0; j <= i; j++){
            int tmp;
            // j가 시작이거나 끝인 경우에는 비교할 것이 하나밖에 없음
            if (j == 0) tmp = dp[i-1][j];
            else if (j == i) tmp = dp[i-1][j-1];

            // 이외의 경우 두 개를 비교하여 큰 값을 저장
            else tmp = max(dp[i-1][j-1], dp[i-1][j]);
            dp[i][j] = triangle[i][j] + tmp;
        }
    }

    // 마지막 줄에서 가장 큰 값을 찾음
    int maxVal = 0;
    for (int j = 0; j < n; j++){
        if (dp[n-1][j] > maxVal){
            maxVal = dp[n-1][j];
        }
    }

    cout << maxVal;
}