
import sys
input = sys.stdin.readline 

N, M, K = map(int, input().split())


graph = []
for _ in range(N):
    line = input()
    graph.append(line) 
    
    
from collections import deque 

q = deque([ (0, 0, 0, K) ]) # x, y, count, canBrokeCount

visited = [
    [
        [
            False for ___ in range(K+1)
        ]
    for _ in range(M)
    ]
    for __ in range(N)
]

visited[0][0][K] = True 
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = -1

while q: 
    curX, curY, count, canBrokeCount = q.popleft() 
    
    if curX == N-1 and curY == M-1: 
        result = count
        break 
    
    for i in range(4):
        nx = curX + dx[i]
        ny = curY + dy[i]
        
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue 
        
        if visited[nx][ny][canBrokeCount] is True: 
            continue 
        
        
        
        if graph[nx][ny] == '0':
            visited[nx][ny][canBrokeCount] = True 
            q.append( (nx, ny, count+1, canBrokeCount) )
        
        else:
            if canBrokeCount == 0 or visited[nx][ny][canBrokeCount-1]: 
                continue 
            visited[nx][ny][canBrokeCount-1] = True 
            q.append( (nx, ny, count+1, canBrokeCount -1) )

print(result+1 if result != -1 else -1)