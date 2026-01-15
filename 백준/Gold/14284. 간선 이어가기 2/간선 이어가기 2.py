import sys

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N)]

for _ in range(M):
    start, end, value = map(int, input().split())
    start -= 1
    end -= 1

    graph[start].append((end, value))
    graph[end].append((start, value))

S, T = map(int, input().split())


def dik(start):
    import heapq

    q = []
    distance = [1e9 for _ in range(N)]
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        value, cur = heapq.heappop(q)

        if distance[cur] < value:
            continue

        for next in graph[cur]:
            if value + next[1] < distance[next[0]]:
                distance[next[0]] = value + next[1]
                heapq.heappush(q, (value + next[1], next[0]))

    return distance


res = dik(S-1)
print(res[T-1])