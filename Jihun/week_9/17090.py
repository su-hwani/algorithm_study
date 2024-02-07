import sys
sys.setrecursionlimit(1000000)

n, m = map(int, input().split())

miro = []
for i in range(n):
    miro.append(list(input()))

count = 0
visited = [[[False, 0] for _ in range(m)] for _ in range(n)]

visit = []
def dfs(i, j):
    now = miro[i][j]

    if visited[i][j][0]: # 방문한 지점
        if visited[i][j][1] == 1: # 탈출가능한 방문한 지점
            return 1
        elif visited[i][j][1] == 2: # 내부에서 사이클 돌고있는 방문한 지점 = 탈출 불가
            return 2
        elif visited[i][j][1] == 3: # 탈출 불가능한 방문한 지점
            return 3
    else: # 방문 안 한 지점
        visit.append([i, j])
        visited[i][j][0] = True
        visited[i][j][1] = 2 # 탈출 가능한지 아닌지 아직 모름
    
    next_i = i
    next_j = j

    if now == 'U':
        next_i += -1
    elif now == 'R':
        next_j += 1
    elif now == 'D':
        next_i += 1
    else:
        next_j += -1

    if next_i >= n or next_i < 0 or next_j >= m or next_j < 0:
        # 탈출 성공
        return 1
    else:
        return dfs(next_i, next_j)
            
        

for i in range(n):
    for j in range(m):
        result = dfs(i, j)
        if result == 1:
            for item in visit:
                visited[item[0]][item[1]] = [True, 1]
                count += 1
        elif result == 2:
            for item in visit:
                visited[item[0]][item[1]] = [True, 3]
        else:
            for item in visit:
                visited[item[0]][item[1]] = [True, 3]
        visit.clear()

print(count)
