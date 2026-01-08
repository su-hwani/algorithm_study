




import sys

input = sys.stdin.readline 

N, M = map(int, input().split())

graph = []

for _ in range(N): 
    line = list(map(int, input().split()))
    graph.append(line)
    

result = 0

for i in range(N):
    for k in range(M):
        
        cur_num = graph[i][k]
        
        if cur_num == 0: 
            continue 
        
        total_side = graph[i][k] * 4 + 2

        
        if i+1 < N: 
            total_side -= min(graph[i+1][k], graph[i][k])
            
        if i-1 >= 0: 
            total_side -= min(graph[i-1][k], graph[i][k])
            
        if k+1 < M: 
            total_side -= min(graph[i][k+1], graph[i][k])
        
        if k-1 >= 0: 
            total_side -= min(graph[i][k-1], graph[i][k])
        
        result += total_side
    
        # print(f"cur_result: {result}")

# print(f"total_result: {result}")
print(result)