import sys

input = sys.stdin.readline 





N = int(input())

graph = list(map(int, input().split()))
dp = [1 for _ in range(N)]

for i in range(N):
    for k in range(i):
        if graph[i] > graph[k]:
            dp[i] = max(dp[i], dp[k] + 1)

print(max(dp))