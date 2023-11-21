n = int(input())

dp = [[0]*10 for _ in range(n+1)]
# n+1을 고쳐야됨..... 1부터하면안됨
for k in range(10):
    dp[1][k] = 1

for i in range(2, n+1):
    for j in range(10):
        if j == 0:
            dp[i][j] = 1
        else:
            dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007

print(sum(dp[n]) % 10007)
