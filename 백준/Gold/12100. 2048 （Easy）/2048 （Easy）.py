N = int(input())
graph = []
for _ in range(N):
    line = list(map(int, input().split()))
    graph.append(line)


from collections import deque
from copy import deepcopy

q = deque([(graph, 0, [])])  # graph, count
result = 0


def compact(line: list, N: int):
    for i in range(1, N):
        startIdx = i

        if line[startIdx] == 0:
            continue

        while startIdx > 0:
            if line[startIdx - 1] == 0:
                line[startIdx - 1] = line[startIdx]
                line[startIdx] = 0
            startIdx -= 1

    for i in range(1, N):
        if line[i - 1] == line[i]:
            line[i - 1] = line[i] * 2
            line[i] = 0

    for i in range(1, N):
        startIdx = i

        if line[startIdx] == 0:
            continue

        while startIdx > 0:
            if line[startIdx - 1] == 0:
                line[startIdx - 1] = line[startIdx]
                line[startIdx] = 0
            startIdx -= 1


while q:
    curGraph, curCount, prevList = q.popleft()

    if curCount == 5:
        for lr in curGraph:
            # if result < max(lr):
            # print(curGraph, prevList)
            # print("-------------")
            result = max(result, max(lr))

        continue

    # up
    curNewGraph = deepcopy(curGraph)
    for k in range(0, N):
        newList = []
        for i in range(N - 1, -1, -1):
            newList.append(curNewGraph[i][k])

        compact(newList, N)

        for i in range(N - 1, -1, -1):
            curNewGraph[i][k] = newList[N - 1 - i]

    q.append((curNewGraph, curCount + 1, prevList + curGraph + ["up"]))

    # down
    curNewGraph = deepcopy(curGraph)
    for k in range(0, N):
        newList = []
        for i in range(0, N):
            newList.append(curNewGraph[i][k])

        compact(newList, N)

        for i in range(0, N):
            curNewGraph[i][k] = newList[i]

    q.append((curNewGraph, curCount + 1, prevList + curNewGraph + ["down"]))

    # right
    curNewGraph = deepcopy(curGraph)
    for i in range(0, N):
        newList = []
        for k in range(N - 1, -1, -1):
            newList.append(curNewGraph[i][k])

        compact(newList, N)

        for k in range(N - 1, -1, -1):
            curNewGraph[i][k] = newList[N - 1 - k]

    q.append((curNewGraph, curCount + 1, prevList + curNewGraph + ["right"]))

    # left
    curNewGraph = deepcopy(curGraph)
    for i in range(0, N):
        newList = []
        for k in range(0, N):
            newList.append(curNewGraph[i][k])

        compact(newList, N)

        for k in range(0, N):
            curNewGraph[i][k] = newList[k]

    q.append((curNewGraph, curCount + 1, prevList + curNewGraph + ["left"]))

print(result)
