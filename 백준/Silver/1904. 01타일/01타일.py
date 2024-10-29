import sys
input = sys.stdin.readline

n = int(input())

graph = [1, 2]
if n == 1 or n == 2:
    pass
else:
    for i in range(2, n):
        new = graph[0] + graph[1]
        graph[0] = graph[1] % 15746
        graph[1] = new % 15746
        

# print(graph[n-1] % 15746)
if n == 1:
    print(graph[0] % 15746)
else:
    print(graph[1] % 15746)