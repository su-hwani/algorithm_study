n, m = map(int, input().split())
arr = []

# 정사각형 입력받기
for i in range(n):
    row = list(map(int, input()))
    arr.append(row)

answer = 0

# 배열이 1x1인 경우
if n == 1 and m == 1:
    answer = arr[0][0]
else:
    # arr 요소 중 값이 1일 때 arr의 전행, 전열, 전행전열 비교해서 가장 작은 것에서 1을 더한다.
    for i in range(1, n):
        for j in range(1, m):
            if arr[i][j] == 1:
                arr[i][j] = min(arr[i-1][j], arr[i][j-1], arr[i-1][j-1]) + 1
                answer = max(answer, arr[i][j])

print(answer * answer)
