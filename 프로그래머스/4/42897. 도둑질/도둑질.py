
def solution(money):
    dp = [m for m in money]

    for i in range(3, len(money)):
        dp[i] = max(dp[i - 2] + money[i], dp[i - 1])

        if i >= 4:
            dp[i] = max(dp[i], dp[i - 3] + money[i])

    first = max(dp)

    dp = [m for m in money]

    for i in range(2, len(money) - 1):
        dp[i] = max(dp[i - 2] + money[i], dp[i - 1])

        if i >= 3:
            dp[i] = max(dp[i], dp[i - 3] + money[i])

    second = max(dp)

    # print(f"first: {first} second: {second}")

    return max(first, second)