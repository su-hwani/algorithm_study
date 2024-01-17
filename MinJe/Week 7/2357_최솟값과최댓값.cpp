#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;
#define MAX 100001
int nums[MAX];
pair<int, int> segtree[4 * MAX];

void init(int index, int start, int end){
    if (start == end){
        segtree[index] = {nums[start], nums[start]};
        return;
    }
    int mid = (start + end) / 2;
    init(index*2, start, mid);
    init(index*2+1, mid+1, end);
    segtree[index] = {min(segtree[index*2].first, segtree[index*2+1].first), max(segtree[index*2].second, segtree[index*2+1].second)};
    return;
}

pair<int, int> solve(int index, int start, int end, int left, int right){
    // 지정된 범위 밖에 있는 경우
    if (right < start || end < left){
        return {2147483647, 0};
    }
    // 지정된 범위 안에 있는 경우
    if (left <= start && end <= right){
        return segtree[index];
    }
    // 범위에 일부 걸쳐 있을 때
    int mid = (start + end)/2;
    pair<int, int> left_solve = solve(index*2, start, mid, left, right);
    pair<int, int> right_solve = solve(index*2+1, mid+1, end, left, right);
    return {min(left_solve.first, right_solve.first), max(left_solve.second, right_solve.second)};
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    for (int i = 1; i <= N; i++){
        cin >> nums[i];
    }

    init(1, 1, N);

    while (M--){
        int a, b;
        cin >> a >> b;
        pair<int, int> ans = solve(1, 1, N, a, b);
        cout << ans.first << " " << ans.second << "\n";
    }
}