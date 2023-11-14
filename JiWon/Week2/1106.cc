#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int c, n; // C: 늘여야 하는 최소 고객 수(~1000),  N: 홍보할 수 있는 도시 수(~20)
    cin >> c >> n;
    
    vector<pair<int, int>> list;
    const int MAX = 1000*100 + 1; // C의 최댓값 * 입력 cost의 최댓값 + 1
    int D[MAX]= {}; // D[cost] = num

    for(int i=0; i<n; i++){
        // 도시별 홍보 정책 저장
        int cost, num;
        cin >> cost >> num;
        list.push_back(make_pair(cost, num));
    }

    for(int i=1; i<MAX; i++){
        for(int j=0; j<n; j++){
            if(i - list[j].first >= 0){
                D[i] = max(D[i], D[i-list[j].first] + list[j].second);
            }
        }
        if(D[i] >= c){ // 최소치 달성하면 cost 출력
            cout << i;
            break;
        }
    }

    return 0;
}
