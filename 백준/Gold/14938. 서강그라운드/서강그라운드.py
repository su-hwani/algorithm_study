



import sys
input = sys.stdin.readline 

N, M, R = map(int, input().split())
node_item = list(map(int, input().split()))
graph = [[] for _ in range(N)]

for _ in range(R): 
    start, end, time = map(int, input().split())
    start -= 1
    end -= 1
    
    graph[start].append((end, time) )
    graph[end].append((start, time))
    
def dik(start): 
    
    import heapq 
    
    q = []
    distance = [1e9 for _ in range(N)]
    
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q: 
        value, node = heapq.heappop(q)
        
        if distance[node] < value:  
            continue 
        
        for i in graph[node]: 
            if value + i[1] < distance[i[0]]: 
                distance[i[0]] = value + i[1]
                heapq.heappush(q, (value + i[1], i[0]))
    
    return distance 

ans = 0

for i in range(N):
    distance = dik(i)
    
    res = 0
    for k in range(N): 
        if distance[k] <= M : 
            res += node_item[k]
    ans = max(ans, res)
# print(f"start: {i} distance: {distance} ans: {ans}")
print(ans)
                
    # 23 