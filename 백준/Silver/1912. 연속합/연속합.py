import sys
input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))

inf = -float('inf')
dp = inf
ans = inf
for i in num:
    dp = max(dp+i, i)
    ans = max(ans, dp)
        
    
print(f"{ans}")