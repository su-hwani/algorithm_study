import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


N = int(input())

numbers = list(map(int, input().split()))
graph = [1 for _ in range(N)]


for i in range(1, N):
    
    for k in range(0, i):
        if numbers[i] > numbers[k]:
            graph[i] = max(graph[i], graph[k]+1)
    

print(max(graph))

#print(graph)