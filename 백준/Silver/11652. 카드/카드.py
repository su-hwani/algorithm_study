



import sys

input = sys.stdin.readline 




N = int(input())

graph = {
    
}

for _ in range(N):
    num = int(input())
    if num in graph: 
        graph[num] += 1
    else:
        graph[num] = 1
        
        
        
a = list(graph.items())

a.sort(key=lambda x:(-x[1], x[0]))

print(a[0][0])

