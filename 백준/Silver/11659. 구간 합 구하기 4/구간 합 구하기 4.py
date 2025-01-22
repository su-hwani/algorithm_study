import sys
input = sys.stdin.readline

N, M = map(int, input().split())

nums = list(map(int, input().split()))

dp = [0 for _ in range(N+1)]
for i in range(1, N+1):
    dp[i] = dp[i-1] + nums[i-1]


for __ in range(M):
    start, end = map(int, input().split())

    
    print(f"{dp[end] - dp[start-1]}")

