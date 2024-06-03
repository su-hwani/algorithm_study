#include <iostream>
using namespace std;

int n, m;
int graph[50][50];
int robotR, robotC, d;

int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int answer = 0;

bool allCleaned(int r, int c){
    for (int i = 0; i < 4; i++){
        int nextR = r + dir[i][0];
        int nextC = c + dir[i][1];
        if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m){
            if (!graph[nextR][nextC]){
                return false;
            }
        }
    }
    return true;
}

void solve(){
    // 1. 현재 칸이 청소되지 않은 경우, 현재 칸을 청소
    if (!graph[robotR][robotC]){
        graph[robotR][robotC] = -1;
        answer++;
    }
    // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    if (allCleaned(robotR, robotC)){
        int nextR = robotR + dir[(d+2)%4][0];
        int nextC = robotC + dir[(d+2)%4][1];
        if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m){
            // 2.1 바라보는 방향을 유지한 채로 한칸 후진할 수 있는 경우
            if (graph[nextR][nextC] != 1){
                robotR = nextR;
                robotC = nextC;
                solve();
            }
            // 2.2 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없는 경우
            else{
                return;
            }
        }
    }
    // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
    else{
        while (true){
            d = (d+3)%4;
            int nextR = robotR + dir[d][0];
            int nextC = robotC + dir[d][1];
            if (0 <= nextR && nextR < n && 0 <= nextC && nextC < m){
                if (!graph[nextR][nextC]){
                    robotR = nextR;
                    robotC = nextC;
                    break;
                }
            }
        }
        solve();
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    cin >> robotR >> robotC >> d;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            cin >> graph[i][j];
        }
    }

    solve();
    cout << answer;
}