n = int(input())
dp = []
for i in range(n):
    dp.append([0, 0, 0])

dp[0] = [1, 1, 1]
# 왼쪽에 사자, 오른쪽 사자, 사자가 안들어감.

for i in range(1, n):
    dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 9901
    dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901
    dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901

print(sum(dp[n-1]) % 9901)
