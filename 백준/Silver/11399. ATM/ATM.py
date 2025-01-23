import sys
input = sys.stdin.readline
N = int(input())
nums = list(map(int, input().split()))

nums.sort()

for i in range(1, N):
    nums[i] = nums[i-1] + nums[i]

print(sum(nums))
