N, M = map(int, input().split())


graph = []

for _ in range(N):
    line = []
    r = input()
    s = ""
    for i in range(len(r)-1, -1, -1):
        s += r[i]
    line.append(s)
    graph.insert(0, line)

from collections import deque

visited = [[[False, False] for __ in range(M)] for _ in range(N)]
q = deque([(0, 0, False, 0)])  # X, Y, 벽 뚫었는지, count, visited
visited[0][0][0] = True 
visited[0][0][1] = False

result = 1e9


while q:
    curX, curY, flag, count = q.popleft()
    # print(f"curX: {curX}, curY: {curY}, count: {count}, flag: {flag}")
    if curX == N - 1 and curY == M - 1:
        result = min(count, result)
        continue

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(4):
        nx = curX + dx[i]
        ny = curY + dy[i]
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue

        if graph[nx][0][ny] == "0":
            if flag is True:  # flag = True
                if visited[nx][ny][1] is False:
                    visited[nx][ny][1] = True
                    q.append((nx, ny, flag, count + 1))
            else: # flag = False
                if visited[nx][ny][0] is False:
                    visited[nx][ny][0] = True
                    q.append((nx, ny, flag, count + 1))
        else:
            if flag is False:  # flag = False
                if visited[nx][ny][1] is False:
                    
                    visited[nx][ny][1] = True
                    q.append((nx, ny, True, count + 1))

print(result + 1 if result != 1e9 else -1)


# 6 4
# 0100
# 1110
# 1000
# 0000
# 0111
# 0000
