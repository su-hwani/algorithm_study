import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [
    str(input().strip()) for x in range(N)
]

from collections import deque

def bfs(x, y):
    queue = deque([(0,0,1)])
    visited = [ [False]*M for _ in range(N) ]
    visited[x][y] = True 
    
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    while queue:
        x, y, dist = queue.popleft()
        if x == N-1 and y == M-1:
            return dist
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<M and graph[nx][ny] == '1' and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, dist+1))
    return -1
    
result = bfs(0, 0)
print(result)