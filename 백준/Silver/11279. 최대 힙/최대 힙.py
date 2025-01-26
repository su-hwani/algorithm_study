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
            continue
        delete_num = heapq.heappop(nums)
        print(f"{-1 * delete_num}")
    else:
        heapq.heappush(nums, -1 * num)