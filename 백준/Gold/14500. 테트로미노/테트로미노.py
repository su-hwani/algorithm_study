import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [
    list(map(int, input().split())) for _ in range(N)
]
visited = [
    [False] * M for _ in range(N)
]

ans = 0

def check(x, y, visited):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue
        
        if visited[nx][ny]:
            return True
    return False
    
def fun(x, y, visited, score, count, start, end):
    global ans 
    # print(f"x: {x}, y: {y}, score: {score}, count: {count}, ans: {ans}")
    if count == 3:
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        for i in range(4):
            nx = start + dx[i]
            ny = end + dy[i]
            
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            
            if visited[nx][ny]:
                continue
            
            visited[nx][ny] = True
            fun(nx, ny, visited, score + graph[nx][ny], count + 1, x, y)
            visited[nx][ny] = False
            
    if count == 4:
        if score > ans:
            ans = score
        return 
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue 
        
        if visited[nx][ny]:
            continue
        
        visited[nx][ny] = True
        fun(nx, ny, visited, score + graph[nx][ny], count + 1, x, y)
        visited[nx][ny] = False
        
for i in range(0, N):
    for k in range(0, M):
        # print(f"i: {i}, k: {k}")
        visited[i][k] = True 
        fun(i, k, visited, graph[i][k], 1, i, k)
        visited[i][k] = False
    
print(ans)