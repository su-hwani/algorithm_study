import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [
    list(map(int, input().split())) for _ in range(M)
]

from collections import deque

queue = deque([])
for i in range(M):
    for k in range(N):
        if graph[i][k] == 1:
            queue.append((i, k))

ans = 0

while queue:
    x, y = queue.popleft()
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx < 0 or nx >= M or ny < 0 or ny >= N:
            continue 
        
        if graph[nx][ny] == -1 or graph[nx][ny] >= 1:
            continue 
        
        graph[nx][ny] = graph[x][y] + 1
        
        if graph[nx][ny] > ans:
            ans = graph[nx][ny]
        
        queue.append((nx, ny))

for i in range(M):
    for k in range(N):
        if graph[i][k] == 0:
            print(-1)
            exit()
            
            
print(ans - 1 if ans > 0 else 0)