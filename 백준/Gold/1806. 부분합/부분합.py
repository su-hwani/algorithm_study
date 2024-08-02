import sys

N, M = map(int, input().split())
num = list(map(int, sys.stdin.readline().split()))

start = 0
end = 0
result = 0
_sum = num[0]

while True:
    if _sum < M: 
        end += 1
        if end == N:
            break
        _sum += num[end]
        
    else: 
        _sum -= num[start]
        if result == 0:
            result = end-start+1
        else:
            result = min(result, end-start+1)
        start += 1
    if end == N:
        break
print(result)