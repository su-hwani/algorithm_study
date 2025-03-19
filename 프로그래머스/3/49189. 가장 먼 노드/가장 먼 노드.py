from collections import deque

def bfs(graph, n):
    max_distance = 0
    
    distance = [0 * x for x in range(n+1)]
    visited = [False for x in range(n+1)]
    
    q = deque([(1, 1)])
    visited[1] = True
    
    while q:
        node, dis = q.popleft()
        distance[node] = dis
        if dis > max_distance:
            max_distance = dis
            
        for i in graph[node]:
            if visited[i] is False:
                q.append((i, dis+1))
                visited[i] = True
    
    return distance, max_distance
    
    
def solution(n, edge):
    graph = {
        x: [] for x in range(1, n+1)
    }
    for e in edge:
        node1, node2 = e
        graph[node1].append(node2)
        graph[node2].append(node1)
    
    distance, max_distance = bfs(graph, n)
    
    answer = distance.count(max_distance)
    return answer