import sys

input = sys.stdin.readline




N = int(input())

graph = []

for _ in range(N):
    A, B = map(int, input().split())

    graph.append((A, B))

result = 0


def backtracking(graph, cur):
    global result

    # print(f"All graph: {graph}, cur: {cur}")

    if cur > N - 1:
        count = 0
        for i in graph:
            if i[0] == 0:
                count += 1
        # print(f"graph: {graph}")
        result = max(result, count)
        return


    curA, curB = graph[cur]

    if curA <= 0:
        backtracking(graph, cur + 1)
        return

    can_hit = False
    for i in range(0, N):
        nextA, nextB = graph[i]

        if nextA <= 0 or cur == i:
            continue

        can_hit = True 
        graph[cur] = (curA - nextB, curB) if curA - nextB > 0 else (0, curB)
        graph[i] = (nextA - curB, nextB) if nextA - curB > 0 else (0, nextB)

        backtracking(graph, cur + 1)

        graph[cur] = (curA, curB)
        graph[i] = (nextA, nextB)

    if not can_hit: 
        backtracking(graph, cur + 1)

backtracking(graph, 0)

print(result)
