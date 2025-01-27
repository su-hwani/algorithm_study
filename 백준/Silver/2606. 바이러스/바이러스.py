import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [
    [] for _ in range(N+1)
]

for _ in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

def fun(graph, start, visited):
    
    visited[start] = True 
    for i in graph[start]:
        # print(start, visited[start], i)
        if visited[i] == False:
            fun(graph, i, visited)

visited = [ False for _ in range(N+1)]


fun(graph, 1, visited)

ans = 0
for i in range(2, len(visited)):
    if visited[i]:
        ans += 1
print(ans)
