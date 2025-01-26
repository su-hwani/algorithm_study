import sys
input = sys.stdin.readline

N = int(input())

import heapq

nums = []

for _ in range(N):
    num = int(input())
    
    if num == 0:
        if len(nums) == 0:
            print(f"{0}")
        else:
            ans = heapq.heappop(nums)
            print(f"{ans[1]}")
    else:
        if num > 0:
            heapq.heappush(nums, (num, num))
        else:
            heapq.heappush(nums, (-1 * num, num))
        