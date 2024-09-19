import sys
sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

dp = [1 for i in range(N)]
prev = [-1 for i in range(N)]

for i in range(0, N):

    for j in range(0,i):
        if dp[i] <= dp[j] and arr[i] > arr[j]:
            dp[i] = dp[j] + 1
            prev[i] = j


max_len = max(dp)
idx = dp.index(max_len)

result = []
while idx != -1:
    result.append(arr[idx])
    idx = prev[idx]


result.sort()

print(max_len)
for i in result:
    print(i, end=" ")