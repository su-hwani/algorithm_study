import sys
sys.setrecursionlimit(10**6)  # 재귀 한도 증가
input = sys.stdin.readline

N, M = map(int, input().split())

# 그래프 입력
graph = [list(input().strip()) for _ in range(N)]
visited = [[False] * M for _ in range(N)]  # 방문 여부 저장

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, prev_x, prev_y, color):
    if visited[x][y]:
        return True  # 이미 방문한 곳을 다시 방문하면 사이클
    
    visited[x][y] = True  # 방문 처리

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == color:
            if (nx, ny) == (prev_x, prev_y): 
                continue  # 직전 노드는 무시 (바로 되돌아가는 경우 방지)

            if dfs(nx, ny, x, y, color):
                return True  # 사이클 발견
    
    return False  # 사이클 발견되지 않음

# 모든 점에서 DFS 탐색
for i in range(N):
    for j in range(M):
        if not visited[i][j]:  # 방문하지 않은 노드에서만 탐색
            if dfs(i, j, -1, -1, graph[i][j]):  # 초기 prev_x, prev_y를 -1로 설정
                print("Yes")
                sys.exit(0)

print("No")  # 모든 탐색이 끝나도 사이클이 없으면 "No" 출력