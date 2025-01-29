import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

ans = 0

def fun(nums, count):
    global ans
    # print(f"nums: {nums}, count: {count}, ans: {ans}")
    
    if len(nums) == 2:
        if count > ans:
            ans = count
        return 
    
    for i in range(1, len(nums)-1):
        new_count = nums[i-1] * nums[i+1]
        new_num = nums[i]
        
        count += new_count
        del nums[i]
        fun(nums, count)
        nums.insert(i, new_num)
        count -= new_count
        
fun(nums, 0)

print(ans)