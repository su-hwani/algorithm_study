#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int c, n; // C는 1000보다 작거나 같은 자연수,  N은 20보다 작거나 같은 자연수
    int cost, num; // 100보다 작거나 같은 자연수

    vector<pair<int, int>> list;
    const int MAX = 1000*100 + 1; // C의 최댓값 * 입력 cost의 최댓값 + 1
    int D[MAX]= {}; // D[cost] = num
    
    cin >> c >> n;
    for(int i=0; i<n; i++){
        cin >> cost >> num;
        list.push_back(make_pair(cost, num));
    }
    
    for(int i=0; i<MAX; i++){
        for(int j=0; j<n; j++){ // 각각의 cost에 대해 모든 정책을 검토
            if(i - list[j].first >= 0){
                D[i] = max(D[i], D[i-list[j].first] + list[j].second);
            }
        }
        if(D[i] >= c){
            cout << i; // 최소치 달성하면 cost 출력
            break;
        }
    }

    return 0;
}
