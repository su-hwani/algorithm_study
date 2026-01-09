import sys

input = sys.stdin.readline

N, L, R = map(int, input().split())
graph = []
for _ in range(N):
    line = list(map(int, input().split()))
    graph.append(line)


from collections import deque


def fun(N, L, R):
    visited = [[False for _ in range(N)] for _ in range(N)]
    is_flag = False

    for i in range(N):
        for k in range(N):
            if visited[i][k]:
                continue

            q = deque()
            q.append((i, k))

            groupScore = graph[i][k]
            group = [[i, k]]
            visited[i][k] = True
            while q:
                curRow, curCol = q.popleft()

                dx = [-1, 1, 0, 0]
                dy = [0, 0, -1, 1]

                curScore = graph[curRow][curCol]

                for x in range(4):
                    nx = curRow + dx[x]
                    ny = curCol + dy[x]

                    # print(f"curRow: {curRow} curCol: {curCol} nx: {nx} ny: {ny} visited: {visited} ")
                    if (
                        N > nx >= 0
                        and N > ny >= 0
                        and visited[nx][ny] is False
                        and R
                        >= max(curScore, graph[nx][ny]) - min(curScore, graph[nx][ny])
                        >= L
                    ):
                        # print("KKKK")
                        q.append((nx, ny))
                        visited[nx][ny] = True
                        group.append([nx, ny])
                        groupScore += graph[nx][ny]
                        

            # print(
            #     f"group: {group}, groupScore: {groupScore}, groupScore // len(group): {groupScore // len(group)}"
            # )
            groupScore = groupScore // len(group)

            for solo in group:
                curRow, curCol = solo[0], solo[1]
                if graph[curRow][curCol] != groupScore: 
                    is_flag = True 
                graph[curRow][curCol] = groupScore

    # print("IN ROOP")
    # print(graph)
    # print("END ROOP")

    return is_flag


result = 0
while True:
    is_flag = fun(N, L, R)
    
    # print(is_flag)
    # break
    if is_flag is False:
        break
    result += 1
    

# print("answer")
# print(graph)

print(result)

# 2 20 50
# 50 30
# 20 40
