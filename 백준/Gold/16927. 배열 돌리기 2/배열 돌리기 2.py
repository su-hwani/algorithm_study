import sys

input = sys.stdin.readline

N, M, R = map(int, input().split())

graph = []

for _ in range(N):
    line = list(map(int, input().split()))
    graph.append(line)


def sequerlize(curRow, curCol, countN, countM, tryCount):
    line = []

    line.extend(graph[curRow][curCol : curCol + countM])
    line.extend(
        [graph[i][curCol + countM - 1] for i in range(curRow + 1, curRow + countN)]
    )
    line.extend(
        list(reversed(graph[curRow + countN - 1][curCol : curCol + countM - 1]))
    )
    line.extend([graph[i][curCol] for i in range(curRow + countN - 2, curRow, -1)])

    tryCount = tryCount % len(line)
    for i in range(tryCount):
        # exchange
        change = line[0]
        line = line[1:]
        line.append(change)
        
    # 크기가 5일 때 
    # 1, 2, 3, 4, 5 
    
    # RetryCount = 1
    # 2, 3, 4, 5, 1
    # RetryCount = 2
    # 3, 4, 5, 1, 2
    # RetryCount = 3
    # 4, 5, 1, 2, 3
    # RetryCount = 4
    # 5, 1, 2, 3, 4
    # RetryCount = 5 
    # 1, 2, 3, 4, 5

    return line


def deSequerlize(line, curRow, curCol, countN, countM):
    index = 0
    for i in range(curCol, curCol + countM):
        graph[curRow][i] = line[index]
        index += 1

    for i in range(curRow + 1, curRow + countN):
        graph[i][curCol + countM - 1] = line[index]
        index += 1

    for i in range(curCol + countM - 2, curCol - 1, -1):
        graph[curRow + countN - 1][i] = line[index]
        index += 1

    for i in range(curRow + countN - 2, curRow, -1):
        graph[i][curCol] = line[index]
        index += 1


maxDepth = min(N, M) // 2

for i in range(maxDepth):
    lines = sequerlize(i, i, N, M, R)
    deSequerlize(lines, i, i, N, M)
    N -= 2
    M -= 2

# print("answer")
for q in graph:
    for k in q: 
        print(k, end=" ")
        
    print("")


# 4 4 2
# 1 2 3 4
# 5 6 7 8
# 9 10 11 12
# 13 14 15 16
