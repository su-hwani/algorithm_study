import sys
from collections import deque
input = sys.stdin.readline


N, M, K = map(int, input().split())

# 추가되는 양분
graph = []

# 나무
treeGraph = [[ deque([]) for _ in range(N)] for _ in range(N)]

# 양분
ground = [[5 for _ in range(N)] for _ in range(N)]

for _ in range(N):
    line = list(map(int, input().split()))
    graph.append(line)


for _ in range(M):
    curX, curY, curScore = map(int, input().split())
    treeGraph[curX - 1][curY - 1].append(curScore)


def fun(N):
    # print(f"봄 START: {treeGraph}")
    # 봄
    deadTreeGraph = [[[] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for k in range(N):
            trees = treeGraph[i][k]
            
            
            liveTrees = deque([])
            for tr in trees:
                if ground[i][k] >= tr and tr != 0: 
                    ground[i][k] -= tr
                    liveTrees.append(tr + 1)
                else:
                    deadTreeGraph[i][k].append(tr)
            treeGraph[i][k] = liveTrees
    # print(f"봄 END: {treeGraph}")

    # print(f"여름 START: {treeGraph}")
    # 여름
    for i in range(N):
        for k in range(N):
            deadTrees = deadTreeGraph[i][k]

            for idx in range(len(deadTrees)):
                ground[i][k] += deadTrees[idx] // 2

    # print(f"여름 END: {treeGraph}")

    # print(f"가을 START: {treeGraph}")
    # 가을
    for i in range(N):
        for k in range(N):
            trees = treeGraph[i][k]

            for tr in trees:
                if tr % 5 == 0:
                    dx = [-1, 1, 0, 0, -1, -1, 1, 1]
                    dy = [0, 0, -1, 1, -1, 1, -1, 1]

                    for n in range(8):
                        nx = i + dx[n]
                        ny = k + dy[n]

                        if N > nx >= 0 and N > ny >= 0:
                            treeGraph[nx][ny].appendleft(1)
                            # print(f"i: {i} k: {k} -> nx: {nx} ny:{ny} treeGraph: {treeGraph}")
    # print(f"가을 END: {treeGraph}")

    # print(f"겨울 START: {treeGraph}")
    # 겨울
    result = 0
    for i in range(N):
        for k in range(N):
            ground[i][k] += graph[i][k]
            result += len(treeGraph[i][k])
    # print(f"겨울 END: {treeGraph}")

    return result


result = 0
for _ in range(K):
    result = fun(N)
    if result == 0:
        break

# print("answer START")
# print(treeGraph)
# print("answer END")
# print(f"answer: {result}")
print(result)


# [1], [1], [1], [], []
# [[5, 1], [1], [1, 1], [1], []], 
# [[1], [5, 1, 1], [1], [1], []],
# [[], [1], [1], [1], []],
# [[], [], [], [], []]