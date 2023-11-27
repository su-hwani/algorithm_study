n = int(input()) # 길이가 n인 오르막수 구하기
MOD = 10007

D = [[0]*10 for _ in range(n+1)] # DP 테이블 생성 및 초기화
for i in range(10):
    D[1][i] = 1

for i in range(2, n+1):
    for j in range(10):
            D[i][j] = sum(D[i-1][:j+1])%MOD

print(sum(D[n])%MOD)
