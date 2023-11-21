n = int(input())
MAX = 100001
MOD = 9901

D = [0] * MAX
D[1], D[2] = 3, 7

if n < 3:
    print(D[n])
else:
    for i in range(3, n+1):
        D[i] = (2*D[i-1] + D[i-2]) % MOD
    print(D[n])
