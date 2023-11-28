t = int(input())

for _ in range(t):
    sticker = []
    n = int(input())
    for _ in range(2):
        arr = list(map(int, input().split()))
        sticker.append(arr)
    dp = [[0] * (n+1) for _ in range(2)]
    dp[0][0] = 0
    dp[1][0] = 0
    dp[0][1] = sticker[0][0]
    dp[1][1] = sticker[1][0]

    for i in range(2, n+1):
        for j in range(2):
            if (j == 0):
                dp[j][i] = max(dp[j+1][i-1], dp[j+1][i-2]) + sticker[j][i-1]
            else:
                dp[j][i] = max(dp[j-1][i-1], dp[j-1][i-2]) + sticker[j][i-1]

    print(max(dp[0][n], dp[1][n]))
