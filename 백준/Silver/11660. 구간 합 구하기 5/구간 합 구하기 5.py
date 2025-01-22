import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

sums = [ [0] * (N+1) for _ in range(N+1)]
for i in range(N):
    for k in range(N):
        new = graph[i][k]
        if k != 0:
            new += sums[i+1][k]
        if i != 0:
            new += sums[i][k+1]
        sums[i+1][k+1] = new - sums[i][k] 

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())

    
    print(f"{sums[x2][y2] - sums[x2][y1-1] - sums[x1-1][y2] + sums[x1-1][y1-1]}")
    