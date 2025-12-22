






import sys

input = sys.stdin.readline 
sys.setrecursionlimit(10**9)




N, M = map(int, input().split())


graph = []

for _ in range(N):
    line = list(map(int, input().split()))
    
    graph.append(line)


for i in range(len(graph)):
    for k in range(len(graph[i])):
        if i == 0 and k == 0: 
            continue 
        
        elif i == 0 : 
            graph[i][k] += graph[i][k-1]
            
        elif k == 0: 
            graph[i][k] += graph[i-1][k]
        
        else: 
            graph[i][k] += max(graph[i-1][k], graph[i][k-1])

print(graph[N-1][M-1])
    