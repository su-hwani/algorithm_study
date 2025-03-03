def bfs(visited, number, start, graph):
    if start not in graph:
        return 
    
    q = []
    for i in graph[start]:
        q.append([start, i])
        visited[start] = number
    
    while q:
        start, end = q.pop()
        if visited[end] == 0:
            for i in graph[end]:
                q.append([end, i])
                visited[end] = number
        
    
def get_graph(n, computers):
    graph = {}
    for i in range(n):
        for k in range(n):
            if i == k:
                continue
            if computers[i][k] == 1:
                if i in graph:
                    graph[i].append(k)
                else:
                    graph[i] = [k]
    return graph

def solution(n, computers):
    graph = get_graph(n, computers)
    visited = [0 for i in range(n)]
    
    number = 1
    for i in range(n):
        if visited[i] == 0:
            bfs(visited, number, i, graph)
            number += 1
    
    
    new = visited.count(0)
    
    answer = set(visited)
    answer = len(answer)
    if new >= 2:
        answer += new - 1
        
    return  answer