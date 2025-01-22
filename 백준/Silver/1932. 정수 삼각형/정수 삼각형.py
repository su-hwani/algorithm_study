import sys

input = sys.stdin.readline

N = int(input())
graph = []


for _ in range(N):
    nums = list(map(int, input().split()))
    graph.append(nums)
    
for i in range(0, N-1):
    for k in range(len(graph[i+1])):
        if k == 0:
            graph[i+1][k] = graph[i][k] + graph[i+1][k]
        elif k == len(graph[i+1])-1:
            graph[i+1][k] = graph[i][k-1] + graph[i+1][k]
        else:
            # print(f"{graph[i][k-2]}  {graph[i+1][k]} {graph[i][k-1]}  {graph[i+1][k]}")
            graph[i+1][k] = max(graph[i][k-1] + graph[i+1][k], graph[i][k] + graph[i+1][k])
        

print(max(graph[-1]))