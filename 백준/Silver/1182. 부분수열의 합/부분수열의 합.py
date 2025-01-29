import sys
input = sys.stdin.readline

N, S = map(int, input().split())

nums = list(map(int, input().split()))

from itertools import combinations

count = 0

for i in range(1, N+1):
    ans = combinations(nums, i)
    for k in ans:
        if sum(k) == S:
            count += 1
            
print(count)