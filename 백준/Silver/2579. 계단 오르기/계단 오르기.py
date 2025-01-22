import sys

input = sys.stdin.readline

N = int(input())

nums = []
for _ in range(N):
    num = int(input())
    nums.append(num)

if len(nums) == 1:
    print(nums[0])
    exit()
elif len(nums) == 2:
    print(nums[0] + nums[1])
    exit()
    

dp = [
    nums[0],
    nums[0] + nums[1],
    max(nums[0] + nums[2], nums[1] + nums[2])
]

for i in range(3, N):
    
    dp.append(max(dp[i-3]+nums[i]+nums[i-1], dp[i-2]+nums[i]))
    


print(dp[-1])