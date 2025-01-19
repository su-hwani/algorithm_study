import sys
input = sys.stdin.readline
N = int(input())

nums = []
max_frequency = 0
nums_count = {}
for i in range(N):
    num = int(input())
    nums.append(num)
    nums_count[num] = nums_count.get(num, 0) + 1
    if nums_count[num] > max_frequency:
        max_frequency = nums_count[num]


nums.sort()
print(round(sum(nums) / N))
print(nums[N//2])
ans = [key for key, value in nums_count.items() if value == max_frequency]
if len(ans) > 1:
    ans.sort()
    print(ans[1])
else:
    print(ans[0])
print(max(nums) - min(nums))

