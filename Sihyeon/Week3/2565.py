n = int(input())
dp = [1]*n
arr = []
for i in range(n):
    ab_arr = list(map(int, input().split()))
    arr.append(ab_arr)

arr.sort()

for i in range(1, n):
    for j in range(0, i):
        if arr[j][1] < arr[i][1]:
            dp[i] = max(dp[i], dp[j]+1)

print(n-max(dp))
