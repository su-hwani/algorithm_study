import sys

input = sys.stdin.readline


# graph[R][C] = K
R, C, K = map(int, input().split())

graph = []

for _ in range(3): 
    line = list(map(int, input().split()))
    graph.append(line)
    

def fun() -> bool:
    global graph

    rowCount = len(graph)
    colCount = len(graph[0])

    if rowCount >= R and colCount >= C and graph[R - 1][C - 1] == K:
        return True

    if rowCount >= colCount:
        # R 연산
        maxRowCount = 0

        for i in range(rowCount):
            rows = graph[i]
            rowsSet = set(rows)
            rowsSet.discard(0)

            sortedRows = [(rows.count(item), item) for item in rowsSet]
            sortedRows.sort(key=lambda x: (x[0], x[1]))
            newSortedRows = []

            for item in sortedRows:
                newSortedRows.append(item[1])
                newSortedRows.append(item[0])

            graph[i] = newSortedRows
            maxRowCount = max(len(newSortedRows), maxRowCount)

        # 0 패딩 및 100개 제한
        for i in range(rowCount):
            rows = graph[i]
            rowsCount = len(rows)

            if rowsCount > 100:
                graph[i] = graph[i][:100]
                continue

            for _ in range(maxRowCount - rowsCount):
                rows.append(0)

            graph[i] = graph[i][:100]
    else:
        # C 연산
        maxColCount = 0

        for i in range(colCount):
            # ⚠️ 매번 현재 행 개수로 갱신
            currentRowCount = len(graph)
            cols = [graph[k][i] for k in range(currentRowCount)]

            colsSet = set(cols)
            colsSet.discard(0)

            sortedCols = [(cols.count(item), item) for item in colsSet]
            sortedCols.sort(key=lambda x: (x[0], x[1]))
            newSortedCols = []

            for item in sortedCols:
                newSortedCols.append(item[1])
                newSortedCols.append(item[0])

            if len(newSortedCols) > 100:
                newSortedCols = newSortedCols[:100]

            maxColCount = max(maxColCount, len(newSortedCols))

            for idx in range(len(newSortedCols)):
                if idx >= len(graph):
                    graph.append([0] * colCount)
                graph[idx][i] = newSortedCols[idx]

            # ⚠️ 나머지 행의 해당 열을 0으로 초기화
            for idx in range(len(newSortedCols), len(graph)):
                graph[idx][i] = 0

        # ⚠️ C연산 후 행 길이를 maxColCount로 맞추기
        for i in range(len(graph)):
            currentLen = len(graph[i])
            if currentLen > 100:
                graph[i] = graph[i][:100]
            elif currentLen < maxColCount:
                graph[i].extend([0] * (min(maxColCount, 100) - currentLen))

    return False


count = 0
while count <= 100 and fun() is False:
    count += 1

print(-1 if count > 100 else count)