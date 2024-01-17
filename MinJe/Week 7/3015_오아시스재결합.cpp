#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;

    stack<pair<int, int>> s;
    unsigned long long answer = 0;

    while (N--){
        int k;
        cin >> k;
        
        if (!s.empty() && s.top().first < k){
            while (!s.empty() && s.top().first < k){
                s.pop();
                answer++;
            }
        }

        if (!s.empty()){
            if (s.top().first == k){
                answer += s.top().second;
                if (s.size() > s.top().second){
                    answer++;
                }
                s.push({k, s.top().second+1});
            }
            else{
                answer++;
                s.push({k, 1});
            }
        }
        else{
            s.push({k, 1}); 
        }
        
    }

    cout << answer;
}

