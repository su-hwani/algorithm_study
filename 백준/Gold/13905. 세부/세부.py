import sys
import heapq  # heapq를 사용하여 우선순위 큐로 개선
input = sys.stdin.readline

n, m = map(int, input().split())
start, end = map(int, input().split())

# 그래프 초기화
graph = [[] for _ in range(n+1)]

# 간선 입력
for _ in range(m):
    u, v, weight = map(int, input().split())
    graph[u].append((v, weight))
    graph[v].append((u, weight))

# 우선순위 큐 사용
q = [(-float('inf'), start)]  # 시작점 (무한대, 시작 노드)
visited = [False] * (n+1)  # 방문 체크

answer = 0

while q:
    cur_weight, cur = heapq.heappop(q)
    cur_weight = -cur_weight  # 최대값을 유지하기 위해 음수로 변환

    if cur == end:
        answer = cur_weight
        break

    if visited[cur]:
        continue

    visited[cur] = True

    for next_node, next_weight in graph[cur]:
        if not visited[next_node]:
            heapq.heappush(q, (-min(cur_weight, next_weight), next_node))

print(answer)