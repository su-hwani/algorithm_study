#include <iostream>
#include <queue>
using namespace std;
#define MAX 1500
int matrix[MAX][MAX];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    priority_queue<int, vector<int>, greater<int>> pq;

    int N;
    cin >> N;
    for (int i = 0; i < N; i++){
        int k;
        cin >> k;
        pq.push(k);
    }
    for (int i = N; i < N*N; i++){
        int k;
        cin >> k;
        pq.push(k);
        pq.pop();
    }

    cout << pq.top();
}