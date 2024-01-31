import sys
input = sys.stdin.readline

n = int(input())
e = int(input())

graph = [[0] * (n + 1) for i in range(n + 1)]
visited = [0] * (n + 1)

for i in range(e):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

nodes = []
def dfs(v):
    visited[v] = 1
    nodes.append(v)

    for i in range(1, n + 1):
        if not visited[i] and graph[v][i]:
            dfs(i)

dfs(1)
print(len(nodes) - 1)