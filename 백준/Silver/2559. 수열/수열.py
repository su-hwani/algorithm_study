import sys
input = sys.stdin.readline

N, M = map(int, input().split())

nums = list(map(int, input().split()))

dp = [0 for i in range(N-M+1)]

for i in range(M):
    dp[0] += nums[i]

for i in range(1, N-M+1):
    
    dp[i] = dp[i-1] - nums[i-1] + nums[i+M-1]

print(max(dp))