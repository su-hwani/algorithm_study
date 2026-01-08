import sys

input = sys.stdin.readline

N, M, R = map(int, input().split())

graph = []

for _ in range(N):
    line = list(map(int, input().split()))
    graph.append(line)


def fun(curN, curM, totalN, totalM):
    # print(f"curN: {curN} curM: {curM} totalN: {totalN} totalM: {totalM}")

    cur = graph[curN][curM]
    last = graph[curN][curM]
    for i in range(curN, curN + totalN - 1):
        last = graph[i + 1][curM]
        graph[i + 1][curM] = cur
        cur = last
    
    # for i in range(len(graph)):
    #         print(f"graph[{i}]: {graph[i]}")
            
    for i in range(curM, curM + totalM - 1):
        last = graph[curN + totalN - 1][i + 1]
        graph[curN + totalN - 1][i + 1] = cur
        cur = last
    
    # for i in range(len(graph)):
    #         print(f"graph[{i}]: {graph[i]}")
            
    for i in range(curN + totalN - 1, curN  + 1, -1):
        last = graph[i - 1][curM + totalM - 1]
        graph[i - 1][curM + totalM - 1] = cur
        cur = last
    
    # for i in range(len(graph)):
    #     print(f"graph[{i}]: {graph[i]}")
        
    for i in range(curM + totalM, curM, -1):
        last = graph[curN][i - 1]
        graph[curN][i - 1] = cur
        cur = last

    # for i in range(len(graph)):
    #     print(f"graph[{i}]: {graph[i]}")
    # print(f"✅ ✅ curN: {curN} curM: {curM} totalN: {totalN} totalM: {totalM}")


for _ in range(R):
    totalCount = min(N, M) // 2 
    for i in range(totalCount):
        fun(i, i, N - i * 2, M - i * 2)

    # print("answer✅")
    # for i in range(len(graph)):
    #     print(f"graph[{i}]: {graph[i]}")
    # print(f"✅ ✅ curN: {curN} curM: {curM} totalN: {totalN} totalM: {totalM}")


# print("answer✅")
for i in graph: 
    for k in i: 
        print(k, end=" ")
    
    print("")

# 1 1 1 1
# 1 1 1 1
# 1 1 1 1
# 1 1 1 1
# 1 1 1 1

# 1 1 1 1 1   4 * 5
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1

# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1
# 1 1 1 1 1




