#include <iostream>
#include <queue>
using namespace std;

int v, e;
priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> pq;
int root[10001];

int Find(int x){
    if (x == root[x]){
        return x;
    }
    return root[x] = Find(root[x]);
}

void Union(int x, int y){
    x = Find(x);
    y = Find(y);
    root[y] = x;
}

void solve(){
    for (int i = 1; i < v; i++){
        root[i] = i;
    }
    int visitedNode = 1;
    long long answer = 0;

    while (visitedNode < v){
        int distance = pq.top().first;
        int start = pq.top().second.first;
        int finish = pq.top().second.second;
        pq.pop();
        
        if (Find(start) != Find(finish)){
            Union(start, finish);
            answer += distance;
            visitedNode++;
        }
    }

    cout << answer;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> v >> e;
    for (int i = 0; i < e; i++){
        int a, b, c;
        cin >> a >> b >> c;
        pq.push({c,{a,b}});
    }

    solve();
}