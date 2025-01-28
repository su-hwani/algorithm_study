import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [ [] for _ in range(N+1) ]
dist = [ 10**9 for _ in range(N+1) ]

K = int(input())
dist[K] = 0

for _ in range(M):
    start, end, value = map(int, input().split())
    
    graph[start].append( (value, end) )
    

import heapq

heap = []
heapq.heappush(heap, (0, K))

while heap:
    cur_dist, u = heapq.heappop(heap)
    
    if dist[u] < cur_dist:
        continue 
    
    for cost, v in graph[u]:
        new_dist = cur_dist + cost
        
        if new_dist < dist[v]:
            dist[v] = new_dist 
            heapq.heappush(heap, (new_dist, v))

for i in dist[1:]:
    print(i if i != 10**9 else "INF")