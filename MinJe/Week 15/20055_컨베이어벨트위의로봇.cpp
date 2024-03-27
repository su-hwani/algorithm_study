#include <iostream>
#include <algorithm>
using namespace std;

int n, k;
int belt[201];
int robotOnBelt[201];
int zeroAreas = 0; // 내구도가 0인 칸의 개수

// 칸의 내구도가 0이라면 zeroAreas를 추가하는 함수
void isZero(int pos){
    if (!belt[pos]){
        zeroAreas++;
    }
}

// 벨트를 한 칸 회전시켜주는 함수
void updateIndex(int& pos){ 
    if (pos != 1){
        pos--;
    }
    else{
        pos = 2*n;
    }
    while (robotOnBelt[pos]){
        robotOnBelt[pos]--;
    }
}

// 로봇을 이동시키는 함수
void moveRobot(int pos){
    if (pos >= n){
        bool check = false;
        if (robotOnBelt[pos-1] && belt[pos]){
            check = true;
        }
        while (robotOnBelt[pos-1] && belt[pos]){
            robotOnBelt[pos-1]--;
            belt[pos]--;
        }
        if (check){
            isZero(pos);
        }
        for (int i = pos-2; i >= pos-n+1; i--){
            if (robotOnBelt[i] && !robotOnBelt[i+1] && belt[i+1]){
                robotOnBelt[i]--;
                robotOnBelt[i+1]++;
                belt[i+1]--;
                isZero(i+1);
            }
        }
    }
    else{
        // 내리는 위치가 2 이상 n-1 이하인 경우
        if (pos != 1){
            bool check = false;
            if (robotOnBelt[pos-1] && belt[pos]){
                check = true;
            }
            while (robotOnBelt[pos-1] && belt[pos]){
                robotOnBelt[pos-1]--;
                belt[pos]--;
            }
            if (check){
                isZero(pos);
            }
            for (int i = pos-2; i >= 1; i--){
                if (robotOnBelt[i] && !robotOnBelt[i+1] && belt[i+1]){
                    robotOnBelt[i]--;
                    robotOnBelt[i+1]++;
                    belt[i+1]--;
                    isZero(i+1);
                }
            }
            if (robotOnBelt[2*n] && !robotOnBelt[1] && belt[1]){
                robotOnBelt[2*n]--;
                robotOnBelt[1]++;
                belt[1]--;
                isZero(1);
            }
            for (int i = 2*n-1; i >= pos+n+1; i--){
                if (robotOnBelt[i] && !robotOnBelt[i+1] && belt[i+1]){
                    robotOnBelt[i]--;
                    robotOnBelt[i+1]++;
                    belt[i+1]--;
                    isZero(i+1);
                }
            }
        }
        // 내리는 위치가 1이 아닌 경우
        else{
            bool check = false;
            if (robotOnBelt[2*n] && belt[1]){
                check = true;
            }
            while (robotOnBelt[2*n] && belt[1]){
                robotOnBelt[2*n]--;
                belt[1]--;
            }
            if (check){
                isZero(1);
            }
            for (int i = 2*n-1; i >= pos+n+1; i--){
                if (robotOnBelt[i] && !robotOnBelt[i+1] && belt[i+1]){
                    robotOnBelt[i]--;
                    robotOnBelt[i+1]++;
                    belt[i+1]--;
                    isZero(i+1);
                }
            }
        }
    }
}

// 로봇을 추가하는 함수
void insertRobot(int pos){
    int target;
    if (pos >= n){
        target = pos-n+1;
    }
    else{
        target = pos+n+1;
    }

    if (belt[target]){
        robotOnBelt[target]++;
        belt[target]--;
        isZero(target);
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;

    for (int i = 1; i <= 2*n; i++){
        cin >> belt[i];
    }

    
    int position = n; // 로봇을 내리는 위치
    int answer = 1;
    while (true){
        updateIndex(position); // 1. 벨트가 한 칸 회전
        moveRobot(position); // 2. 로봇 이동
        insertRobot(position); // 3. 로봇 추가
        if (zeroAreas >= k){
            cout << answer;
            return 0;
        }

        answer++;
    }
}