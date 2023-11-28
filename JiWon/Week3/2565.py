n = int(input()) # 두 전봇대 사이의 전깃줄의 개수 (100 이하의 자연수)

pole = [[0, 0] for _ in range(n)]
for i in range(n):
    pole[i][0], pole[i][1] = map(int, input().split()) # 전깃줄 위치 입력받기

pole.sort(key=lambda x: x[0]) # A 전봇대 기준 오름차순 정렬

D = [1] * n # LIS 찾기 위한 DP 테이블 (B 전봇대 기준)
for i in range(1, n):
    for j in range(i):
        if pole[j][1] < pole[i][1]: # 직전 값보다 크다면?
            D[i] = max(D[i], D[j]+1)

print(n - max(D)) # 구해준 LIS의 길이를 제외한 게 지워야하는 최소한의 전깃줄 개수

