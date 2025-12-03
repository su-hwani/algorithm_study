import sys

input = sys.stdin.readline


N = 8
graph = []


from collections import deque

q = deque([(0, 0, 0)])  # curX, curY, curTime
curTime = 0
result = 0
visited = [[[False for _ in range(8)] for _ in range(8)] for _ in range(8)]

for _ in range(N - 1, -1, -1):
    line = input().strip()
    graph.insert(0, line)

    for i in range(8):
        if line[i] == "#":
            for k in range(_, -1, -1):
                visited[k][i][_ - k] = True

dx = [-1, 1, 0, 0, -1, -1, 1, 1, 0]
dy = [0, 0, -1, 1, 1, -1, 1, -1, 0]

while q:
    curX, curY, curTime = q.popleft()
    

    if curTime >= 7:
        result = 1
        break

    for i in range(9):
        nx = curX + dx[i]
        ny = curY + dy[i]

        if nx < 0 or nx >= 8 or ny < 0 or ny >= 8:
            continue

        if visited[nx][ny][curTime + 1] is False and visited[nx][ny][curTime] is False:
            q.append((nx, ny, curTime + 1))
    # print(f"curX: {curX}, curY: {curY}, curTime: {curTime}, q: {q}")

print(result)
# print(graph)

# for i in range(8):
#     for k in range(8):
#         for p in range(8):
#             if visited[i][k][p] is True:
#                 print(i, k ,p)
