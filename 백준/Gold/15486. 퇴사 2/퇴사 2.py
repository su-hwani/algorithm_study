






import sys

input = sys.stdin.readline 


N = int(input())
graph = []
visited = [0 for _ in range(N+1)]
for _ in range(N):
    time, score = map(int, input().split())
    graph.append( (time, score) )

    

stop = 0

for i in range(N):
    
    cur = graph[i]
    t, s = cur[0], cur[1]
    # print(f"cur: {cur}, visited: {visited}, i: {i}, graph[i]: {graph[i]}")
    if visited[i] < visited[i - 1]:
        visited[i] = visited[i - 1]
    if i + t < N + 1: 
        
        # print(f"i: {i} i-1: {i-1}, visited[i] : {visited[i]}, visited[i-1]:{visited[i-1]}")
        
        visited[i + t] = max(visited[i+t], visited[i] + s)
        
    



print(max(visited))