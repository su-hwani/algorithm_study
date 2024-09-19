import sys
import heapq
input = sys.stdin.readline

INF = int(1e9)  # 무한을 의미하는 값으로 10억 설정

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)
prev = [-1] * (n+1)

for _ in range(m):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

start, end = map(int, input().split())

q = []
heapq.heappush(q, (0, start))
distance[start] = 0

while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist: 
        continue
    for v, w in graph[now]:
        cost = dist + w
        if cost < distance[v]:
            distance[v] = cost
            prev[v] = now
            heapq.heappush(q, (cost, v))


q = []
idx = end
while prev[idx] != -1:
    q.append(idx)
    idx = prev[idx]
q.append(idx)
q.reverse()

print(distance[end])
print(len(q))
for i in q:
    print(i, end=" ")