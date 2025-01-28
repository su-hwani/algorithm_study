import sys
input = sys.stdin.readline

N, E = map(int, input().split())

INF = int(1e9)

graph = [
    [] for _ in range(N+1)
]

for _ in range(E):
    start, end, value = map(int, input().split())
    graph[start].append( (value, end) )
    graph[end].append( (value, start) )

M1, M2 = map(int, input().split())

import heapq 

def fun(start):
    dist = [
        INF for _ in range(N+1)
    ] 
    
    heap = []
    heapq.heappush(heap, (0, start))
    dist[start] = 0
    while heap:
        cur_dist, cur_node = heapq.heappop(heap)
        if dist[cur_node] < cur_dist:
            continue
        for cost, new_end in graph[cur_node]:
            new_dist = cur_dist + cost 
            if new_dist < dist[new_end]:
                dist[new_end] = new_dist
                heapq.heappush(heap, (new_dist, new_end))
    return dist 

dist1 = fun(1)   

dist2 = fun(M1)

dist3 = fun(M2)  

path1 = dist1[M1] + dist2[M2] + dist3[N]
path2 = dist1[M2] + dist3[M1] + dist2[N]

# print(path1, path2)
# print(f"dist1[M1]: {dist1[M1]}, dist2[M2]: {dist2[M2]}, dist3[N]: {dist3[N]}, dist1[M2]: {dist1[M2]}, dist3[M1]: {dist3[M1]}, dist2[N]: {dist2[N]}")
result = min(path1, path2)

print(result if result < 10**9 else -1)