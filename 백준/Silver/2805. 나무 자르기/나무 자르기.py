import sys
input = sys.stdin.readline

N, M = map(int, input().split())

nums = list(map(int, input().split()))

start = 0
end = max(nums)
result = 0

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in nums:
        if i > mid:
            count += (i-mid)

    if count >= M:
        result = mid
        start = mid + 1
    else:
        end = mid - 1
    
    # print(f"start: {start}, end: {end}, mid: {mid}, ans: {count}")
    
print(result)