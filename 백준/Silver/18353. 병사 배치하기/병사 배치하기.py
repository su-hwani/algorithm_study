def min_soldiers_to_remove(n, arr):
    dp = [1] * n  # DP 테이블 초기화

    for i in range(1, n):
        for j in range(0, i):
            if arr[j] > arr[i]:  # 감소 조건
                dp[i] = max(dp[i], dp[j] + 1)

    max_lds_length = max(dp)  # 최장 감소 부분 수열 길이
    return n - max_lds_length  # 제거해야 하는 병사 수

# 입력
n = int(input())
arr = list(map(int, input().split()))

# 출력
print(min_soldiers_to_remove(n, arr))