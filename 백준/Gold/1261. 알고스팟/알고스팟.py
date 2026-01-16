import sys

input = sys.stdin.readline

M, N = map(int, input().split())

graph = []

for _ in range(N):
    line = str(input().strip())
    graph.append(line)
    
from collections import deque 

q = deque([])
visited = {} 
q.append( (0,0,0) ) # X, Y, time 
visited[(0,0)] = 0

ans = N * M + 1
while q: 
    cur_x, cur_y, time = q.popleft() 
    
    if cur_x == N-1 and cur_y == M-1: 
        ans = min(ans, time)
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    for i in range(4): 
        nx = cur_x + dx[i]
        ny = cur_y + dy[i]
        ntime = time 
            
        if N > nx >= 0 and M > ny >= 0 and ((nx, ny) not in visited): 
            if graph[nx][ny] == "1":
                ntime += 1
                q.append((nx, ny, ntime))
            else: 
                q.appendleft((nx, ny, ntime))
            visited[(nx, ny)] = ntime 
    
            
    # print(f"cur_x: {cur_x} cur_y: {cur_y} time: {time} q: {q}")

# print(f"ans: {ans}")
print(ans)
            

    

